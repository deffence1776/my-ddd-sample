package example.infra.datasource.context.reservation;

import example.domain.concerns.reservation.entities.ProgramHolding;
import example.domain.concerns.reservation.entities.Ticket;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.capacity.CurrentTicketCapacity;
import example.domain.values.tickets.num.BoundaryToWarnNum;
import example.domain.values.tickets.num.CurrentTicketNum;
import example.domain.values.tickets.num.MaxTicketNum;
import example.domain.values.tickets.capacity.TicketCapacity;
import example.domain.values.tickets.price.TicketUnitPrice;

public class TicketDataMapping {

    TicketCode ticketCode;
    TicketUnitPrice ticketUnitPrice;
    CurrentTicketCapacity currentTicketCapacity;


    public TicketDataMapping(
            String ticketCode,
            int ticketPrice,
            int ticketCapacity,
            int ticketReservationNum,
            int ticketBoundaryToWarn) {

        this.ticketCode = new TicketCode(ticketCode);
        var ticketCapacity1 = new TicketCapacity(new MaxTicketNum(ticketCapacity), new BoundaryToWarnNum(ticketBoundaryToWarn));
        this.currentTicketCapacity = new CurrentTicketCapacity(ticketCapacity1, new CurrentTicketNum(ticketReservationNum));

        this.ticketUnitPrice = new TicketUnitPrice(ticketPrice);

    }

    public Ticket getTicket(ProgramHolding holding) {
        return new Ticket(ticketCode, ticketUnitPrice, currentTicketCapacity, holding);
    }
}
