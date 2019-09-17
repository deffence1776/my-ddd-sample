package example.infra.datasource.context.reservation;

import org.apache.ibatis.annotations.*;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.num.RequestedTicketNum;
import example.infra.datasource.common.annotation.DatasourceMapper;

@DatasourceMapper
interface TicketReservationMapper {


    @Delete("DELETE " +
            " FROM ticket_stock  " +
            " WHERE ticket_code=  " +
            " #{ticketCode.value}" +
            " AND ticket_stock_id in (" +
            " SELECT ticket_stock_id FROM ticket_stock" +
            " WHERE ticket_code= #{ticketCode.value}" +
            " LIMIT  #{requestedTicketNum.value}" +
            " )")
    int deleteTicketStock(@Param("ticketCode") TicketCode ticketCode,
                          @Param("requestedTicketNum") RequestedTicketNum requestedTicketNum);


    @Insert(
            "INSERT INTO ticket_reservation" +
                    "(" +
                    " reservation_id," +
                    "ticket_code," +
                    "reservation_timestamp," +
                    "ticket_reservation_num," +
                    "username ) " +
                    " VALUES(" +
                    " #{reservationId}," +
                    " #{ticketCode.value}," +
                    " #{reservationDatetime.value}," +
                    " #{reservedTicketNum.value}," +
                    " #{theaterUsername.value}" +
                    ")")
    @SelectKey(before = true, keyProperty = "reservationId", statement = "SELECT NEXTVAL('reservation_id_seq')", resultType = Long.class)
    int register(ReservationDataMapping reservationDataMapping);


}
