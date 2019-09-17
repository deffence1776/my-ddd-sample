package example.domain.concerns.reservation.repositories;

import example.domain.values.reservations.TicketReservationDateTime;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.num.RequestedTicketNum;
import example.domain.values.tickets.num.ReservedTicketNum;
import example.domain.values.user.TheaterUsername;

public interface TicketReservationRepository {

    ReservedTicketNum secureTicket(TicketCode ticketCode, RequestedTicketNum requestedTicketNum);

    TicketReservationId register(TicketCode ticketCode, ReservedTicketNum reservedTicketNum, TheaterUsername theaterUsername, TicketReservationDateTime reservationDatetime);
}
