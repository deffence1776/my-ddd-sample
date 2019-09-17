package example.domain.concerns.searchReservation.dao;

import example.domain.concerns.searchReservation.beans.ReservationBean;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.user.TheaterUsername;

import java.util.Optional;

public interface TicketReservationBeanDao {

    Optional<ReservationBean> findById(TicketReservationId ticketReservationId, TheaterUsername theaterUsername);
}
