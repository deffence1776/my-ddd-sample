package example.domain.concerns.searchReservation.beans;

import example.domain.values.reservations.TicketReservationDateTime;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.num.ReservedTicketNum;

public class ReservationBean {

    TicketCode ticketCode;
    TicketReservationId ticketReservationId;
    ReservedTicketNum reservedTicketNum;
    TicketReservationDateTime ticketReservationDateTime;

    public ReservationBean(TicketCode ticketCode, TicketReservationId ticketReservationId, ReservedTicketNum reservedTicketNum, TicketReservationDateTime ticketReservationDateTime) {
        this.ticketCode = ticketCode;
        this.ticketReservationId = ticketReservationId;
        this.reservedTicketNum = reservedTicketNum;
        this.ticketReservationDateTime = ticketReservationDateTime;
    }

    public TicketCode getTicketCode() {
        return ticketCode;
    }

    public TicketReservationId getTicketReservationId() {
        return ticketReservationId;
    }

    public ReservedTicketNum getReservedTicketNum() {
        return reservedTicketNum;
    }

    public TicketReservationDateTime getTicketReservationDateTime() {
        return ticketReservationDateTime;
    }
}
