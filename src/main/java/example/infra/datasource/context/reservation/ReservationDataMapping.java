package example.infra.datasource.context.reservation;

import example.domain.values.reservations.TicketReservationDateTime;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.num.ReservedTicketNum;
import example.domain.values.user.TheaterUsername;

public class ReservationDataMapping {

    long reservationId;
    TicketCode ticketCode;
    TicketReservationDateTime reservationDatetime;
    ReservedTicketNum reservedTicketNum;
    TheaterUsername theaterUsername;

    public ReservationDataMapping(TicketCode ticketCode, TicketReservationDateTime ticketReservationDateTime,
                                  ReservedTicketNum reservedTicketNum, TheaterUsername theaterUsername) {
        this.ticketCode = ticketCode;
        this.reservationDatetime = ticketReservationDateTime;
        this.reservedTicketNum = reservedTicketNum;
        this.theaterUsername = theaterUsername;
    }



}
