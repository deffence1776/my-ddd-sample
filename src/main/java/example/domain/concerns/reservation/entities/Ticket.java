package example.domain.concerns.reservation.entities;

import example.domain.concerns.reservation.exeptions.RequestedTicketNumNotSatisfiedException;
import example.domain.concerns.reservation.repositories.TicketReservationRepository;
import example.domain.concerns.reservation.result.ReservationCheckResult;
import example.domain.concerns.reservation.rules.CapacitySpec;
import example.domain.concerns.reservation.rules.ScheduleSpec;
import example.domain.values.reservations.TicketReservationDateTime;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.capacity.CurrentTicketCapacity;
import example.domain.values.tickets.num.RequestedTicketNum;
import example.domain.values.tickets.price.TicketUnitPrice;
import example.domain.values.tickets.price.TotalPrice;
import example.domain.values.user.TheaterUsername;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    TicketCode ticketCode;
    TicketUnitPrice ticketUnitPrice;
    CurrentTicketCapacity currentTicketCapacity;
    ProgramHolding programHolding;

    public Ticket(TicketCode ticketCode, TicketUnitPrice ticketUnitPrice, CurrentTicketCapacity currentTicketCapacity, ProgramHolding programHolding) {
        this.ticketCode = ticketCode;
        this.ticketUnitPrice = ticketUnitPrice;
        this.currentTicketCapacity = currentTicketCapacity;
        this.programHolding = programHolding;
    }

    public ReservationCheckResult checkCondition(RequestedTicketNum requestedTicketNum) {
        var errorMessages = new ArrayList<String>();

        new CapacitySpec()
                .check(currentTicketCapacity).ifPresent(errorMessages::add);

        new ScheduleSpec()
                .check(programHolding.holdingSchedule).ifPresent(errorMessages::add);

        var result = new ReservationCheckResult(List.copyOf(errorMessages),
                ticketUnitPrice.total(requestedTicketNum.toInt()));

        return result;
    }

    public TicketReservationId registerTicketReservation(RequestedTicketNum requestedTicketNum,
                                                         TheaterUsername theaterUsername,
                                                         TicketReservationRepository ticketReservationRepository)
            throws RequestedTicketNumNotSatisfiedException {

        var reservedTicketNum = ticketReservationRepository.secureTicket(ticketCode, requestedTicketNum);

        if (!requestedTicketNum.isCompleted(reservedTicketNum)) {
            throw new RequestedTicketNumNotSatisfiedException(
                    programHolding.programCode,
                    programHolding.holdingId,
                    ticketCode);
        }

        var reservationDatetime = TicketReservationDateTime.now();

        return ticketReservationRepository.register(ticketCode,
                reservedTicketNum,
                theaterUsername,
                reservationDatetime);
    }
}
