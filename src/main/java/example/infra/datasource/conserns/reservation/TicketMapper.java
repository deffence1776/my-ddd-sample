package example.infra.datasource.context.reservation;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;
import example.infra.datasource.common.annotation.DatasourceMapper;

import java.util.Optional;

@DatasourceMapper
public interface TicketMapper {

    @Select("SELECT " +
            "ticket.ticket_code," +
            "ticket_price," +
            "ticket_capacity," +
            "COALESCE(ticket_stock_count.ticket_reservation_num,  0) AS ticketReservationNum," +
            "ticket_boundary_to_warn" +
            " FROM ticket " +
            " LEFT OUTER JOIN (SELECT  " +
            "       ticket_code , SUM(ticket_reservation_num) AS ticket_reservation_num" +
            "       FROM " +
            "       ticket_reservation " +
            "       WHERE ticket_code = #{ticketCode.value} " +
            "       GROUP BY ticket_code) ticket_stock_count " +
            "   ON ticket.ticket_code = ticket_stock_count.ticket_code " +
            "WHERE " +
            " ticket.ticket_code  = #{ticketCode.value} ")
    Optional<TicketDataMapping> findOne(@Param("ticketCode") TicketCode ticketCode);

    @Select(" SELECT " +
            "        program_code" +
            "        ,holding_id" +
            "        ,holding_startDate  " +
            "        ,holding_startTime "  +
            "        ,holding_endTime  " +
            "        ,holding_openTimeMargin  " +
            " FROM holding " +
            " WHERE " +
            " holding_id =#{holdingId.value} " +
            " AND" +
            " program_code= #{programCode.value}")
    Optional<ProgramHoldingDataMapping> findOneHolding(@Param("programCode") ProgramCode programCode,
                                                       @Param("holdingId") HoldingId holdingId);


}
