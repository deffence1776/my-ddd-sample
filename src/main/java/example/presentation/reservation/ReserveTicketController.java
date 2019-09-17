package example.presentation.reservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import example.application.services.reservation.ReservationRegisterService;
import example.domain.concerns.reservation.exeptions.RequestedTicketNumNotSatisfiedException;
import example.application.queryservices.reservation.ReservationQueryService;
import example.application.queryservices.tickets.TicketQueryService;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;
import example.fw.bindings.validations.ValueObject;
import example.fw.security.SecurityAuthentication;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("reserve")
public class ReserveTicketController {

    TicketQueryService ticketQueryService;
    ReservationQueryService reservationQueryService;
    ReservationRegisterService reservationRegisterService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReserveTicketController.class);


    public ReserveTicketController(TicketQueryService ticketQueryService, ReservationQueryService reservationQueryService, ReservationRegisterService reservationRegisterService) {
        this.ticketQueryService = ticketQueryService;
        this.reservationQueryService = reservationQueryService;
        this.reservationRegisterService = reservationRegisterService;
    }

    @ModelAttribute
    public TicketRequestForm ticketRequestForm() {
        return new TicketRequestForm();
    }


    @GetMapping
    public String index(@ModelAttribute @Valid ProgramCode programCode,
                        @ModelAttribute @Valid @ValueObject(parameterType = Integer.class) HoldingId holdingId,
                        @ModelAttribute @Valid TicketCode ticketCode,
                        Model model) {

        var ticket = ticketQueryService.queryTicket(programCode, holdingId, ticketCode);
        model.addAttribute(ticket);

        return "reserve/index";
    }

    @PostMapping(path = "doReserve")
    public String doReserve(@ModelAttribute @Valid ProgramCode programCode,
                            @ModelAttribute @Valid @ValueObject(parameterType = Integer.class) HoldingId holdingId,
                            @ModelAttribute @Valid TicketCode ticketCode,
                            @Validated TicketRequestForm ticketRequestForm,
                            BindingResult result,
                            Model model,
                            @AuthenticationPrincipal SecurityAuthentication authentication) throws RequestedTicketNumNotSatisfiedException {

        if (result.hasErrors()) {
            return index(programCode, holdingId, ticketCode, model);
        }

        var checkResult = reservationRegisterService.check(programCode,
                holdingId,
                ticketCode,ticketRequestForm.requestedTicketNum);

        if (checkResult.hasErrors()) {
            model.addAttribute(checkResult);
            return index(programCode, holdingId, ticketCode, model);
        }

        var reservationId = reservationRegisterService.registerTicketReservation(programCode,
                holdingId,
                ticketCode,
                ticketRequestForm.requestedTicketNum,
                authentication.getUserBean().getTheaterUsername());

        var reservationBean = reservationQueryService.queryOne(reservationId, authentication.getUserBean().getTheaterUsername())
                .orElseThrow();
        model.addAttribute(reservationBean);

        return "reserve/complete";
    }


    @ExceptionHandler(RequestedTicketNumNotSatisfiedException.class)
    public String handle(WebRequest request, RequestedTicketNumNotSatisfiedException ex, RedirectAttributes redirectAttributes) {

        redirectAttributes.addAttribute(ex.getProgramCode());
        redirectAttributes.addAttribute(ex.getHoldingId());
        redirectAttributes.addFlashAttribute("messages", List.of(ex.getMessage()));

        return "redirect:/tickets";
    }
}
