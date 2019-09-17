package example.application.services.reservation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import example.domain.concerns.reservation.exeptions.RequestedTicketNumNotSatisfiedException;
import example.domain.concerns.reservation.repositories.TicketRepository;
import example.domain.concerns.reservation.repositories.TicketReservationRepository;
import example.domain.concerns.reservation.result.ReservationCheckResult;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.num.RequestedTicketNum;
import example.domain.values.user.TheaterUsername;

@Service
public class ReservationRegisterService {

    TicketRepository ticketRepository;
    TicketReservationRepository ticketReservationRepository;

    public ReservationRegisterService(TicketRepository ticketRepository, TicketReservationRepository ticketReservationRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketReservationRepository = ticketReservationRepository;
    }

    @Transactional
    public ReservationCheckResult check(ProgramCode programCode,
                                        HoldingId holdingId,
                                        TicketCode ticketCode,
                                        RequestedTicketNum requestedTicketNum) {

        var aggregate = ticketRepository.findOne(programCode,
                holdingId,
                ticketCode);

        return aggregate.checkCondition(requestedTicketNum);
    }

    @Transactional(rollbackFor = RequestedTicketNumNotSatisfiedException.class)
    public TicketReservationId registerTicketReservation(ProgramCode programCode,
                                                         HoldingId holdingId,
                                                         TicketCode ticketCode,
                                                         RequestedTicketNum requestedTicketNum,
                                                         TheaterUsername theaterUsername) throws RequestedTicketNumNotSatisfiedException {
        var ticket = ticketRepository.findOne(programCode, holdingId, ticketCode);
        assert !ticket.checkCondition(requestedTicketNum).hasErrors();

        return ticket
                .registerTicketReservation(
                        requestedTicketNum,
                        theaterUsername,
                        ticketReservationRepository);
    }
}
