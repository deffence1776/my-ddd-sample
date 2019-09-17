package example.application.queryservices.reservation;

import org.springframework.stereotype.Service;
import example.domain.concerns.searchReservation.dao.TicketReservationBeanDao;
import example.domain.concerns.searchReservation.beans.ReservationBean;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.user.TheaterUsername;

import java.util.Optional;

@Service
public class ReservationQueryService {

    TicketReservationBeanDao ticketReservationBeanDao;

    public ReservationQueryService(TicketReservationBeanDao ticketReservationBeanDao) {
        this.ticketReservationBeanDao = ticketReservationBeanDao;
    }

    public Optional<ReservationBean> queryOne(TicketReservationId ticketReservationId, TheaterUsername theaterUsername){
        return ticketReservationBeanDao.findById(ticketReservationId,theaterUsername);
    }
}
