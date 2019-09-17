package example.infra.datasource.context.reservation;

import org.springframework.stereotype.Repository;
import example.domain.concerns.reservation.repositories.TicketReservationRepository;
import example.domain.values.reservations.TicketReservationDateTime;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.num.RequestedTicketNum;
import example.domain.values.tickets.num.ReservedTicketNum;
import example.domain.values.user.TheaterUsername;

@Repository
class TicketReservationRepositoryDatasource implements TicketReservationRepository {

    TicketReservationMapper ticketReservationMapper;

    public TicketReservationRepositoryDatasource(TicketReservationMapper ticketReservationMapper) {
        this.ticketReservationMapper = ticketReservationMapper;
    }

    @Override
    public ReservedTicketNum secureTicket(TicketCode ticketCode,
                                          RequestedTicketNum requestedTicketNum) {
        var deletedNum = ticketReservationMapper.deleteTicketStock(ticketCode, requestedTicketNum);
        return new ReservedTicketNum(deletedNum);
    }

    @Override
    public TicketReservationId register(TicketCode ticketCode, ReservedTicketNum reservedTicketNum, TheaterUsername theaterUsername, TicketReservationDateTime reservationDatetime) {

        var registrationData = new ReservationDataMapping(ticketCode,reservationDatetime,reservedTicketNum,theaterUsername);
        ticketReservationMapper.register(registrationData);
        return new TicketReservationId(registrationData.reservationId);
    }


}
