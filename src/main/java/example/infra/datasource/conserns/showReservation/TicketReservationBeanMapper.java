package example.infra.datasource.context.searchReservation;

import org.apache.ibatis.annotations.*;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.user.TheaterUsername;
import example.infra.datasource.common.annotation.DatasourceMapper;

import java.util.Optional;

@DatasourceMapper
interface TicketReservationBeanMapper {

    @Select("SELECT " +
            "reservation_id," +
            "ticket_code," +
            "reservation_timestamp," +
            "ticket_reservation_num," +
            "username" +
            " FROM ticket_reservation " +
            " WHERE " +
            "  reservation_id = #{ticketReservationId.value}" +
            "  AND" +
            "  username = #{theaterUsername.value}")
    Optional<ReservationBeanMapping> findOne(@Param("ticketReservationId") TicketReservationId ticketReservationId,
                                             @Param("theaterUsername") TheaterUsername theaterUsername);

}
