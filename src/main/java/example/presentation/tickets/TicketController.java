package example.presentation.tickets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import example.application.queryservices.tickets.TicketQueryService;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;
import example.fw.bindings.validations.ValueObject;

import javax.validation.Valid;

@Controller
@RequestMapping("tickets")
public class TicketController {

    TicketQueryService ticketQueryService;

    public TicketController(TicketQueryService ticketQueryService) {
        this.ticketQueryService = ticketQueryService;
    }

    @GetMapping
    public String index(@ModelAttribute @Valid
                        ProgramCode programCode,
                        @ModelAttribute @Valid @ValueObject(parameterType = Integer.class)
                        HoldingId holdingId,
                        Model model) {
        var tickets = ticketQueryService.queryTickets(programCode, holdingId);
        model.addAttribute(tickets);

        return "tickets/index";
    }

    @GetMapping("{ticketCode}")
    public String ticket(@ModelAttribute("programCode") @Valid
                                 ProgramCode programCode,
                         @ModelAttribute("holdingId") @Valid @ValueObject(parameterType = Integer.class)
                                 HoldingId holdingId,
                         Model model,
                         @PathVariable @ModelAttribute("ticketCode") @Valid
                                 TicketCode ticketCode) {
        var ticketBeans = ticketQueryService.queryTickets(programCode, holdingId);
        model.addAttribute(ticketBeans);

        return "tickets/index";
    }
}
