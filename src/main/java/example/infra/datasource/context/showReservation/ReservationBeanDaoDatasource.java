package example.infra.datasource.context.searchReservation;

import org.springframework.stereotype.Repository;
import example.domain.concerns.searchReservation.dao.TicketReservationBeanDao;
import example.domain.concerns.searchReservation.beans.ReservationBean;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.user.TheaterUsername;

import java.util.Optional;

@Repository
public class ReservationBeanDaoDatasource implements TicketReservationBeanDao {

    TicketReservationBeanMapper ticketReservationBeanMapper;

    public ReservationBeanDaoDatasource(TicketReservationBeanMapper ticketReservationBeanMapper) {
        this.ticketReservationBeanMapper = ticketReservationBeanMapper;
    }

    @Override
    public Optional<ReservationBean> findById(TicketReservationId ticketReservationId, TheaterUsername theaterUsername) {

        return ticketReservationBeanMapper.findOne(ticketReservationId,theaterUsername)
                .map(ReservationBeanMapping::getReservation);
    }
}
