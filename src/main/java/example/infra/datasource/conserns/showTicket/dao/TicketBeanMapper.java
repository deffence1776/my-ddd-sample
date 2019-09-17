package example.infra.datasource.context.searchTicket.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;
import example.infra.datasource.common.annotation.DatasourceMapper;

import java.util.List;
import java.util.Optional;

@DatasourceMapper
public interface TicketBeanMapper {
    @Select("SELECT " +
            "ticket.ticket_code," +
            "ticket.holding_id," +
            "ticket_name," +
            "ticket_price," +
            "ticket_capacity," +
            " COALESCE(ticket_stock_count.ticket_reservation_num, 0) AS ticketReservationNum," +
            " ticket_boundary_to_warn" +
            " FROM ticket " +
            " JOIN holding " +
            " ON ticket.holding_id = holding.holding_id " +
            " LEFT OUTER JOIN (SELECT  " +
            "       ticket_code , SUM(ticket_reservation_num) AS ticket_reservation_num" +
            "       FROM " +
            "       ticket_reservation " +
            "       GROUP BY ticket_code) ticket_stock_count " +
            "       ON ticket.ticket_code = ticket_stock_count.ticket_code " +
            "WHERE " +
            " ticket.holding_id = #{holdingId.value} " +
            " AND" +
            " holding.program_code = #{programCode.value} " +
            " ORDER BY holding.program_code, ticket.holding_id,ticket.ticket_code")
    List<TicketBeanMapping> findAll(@Param("programCode") ProgramCode programCode,
                                    @Param("holdingId")HoldingId holdingId);


    @Select("SELECT " +
            "ticket.ticket_code," +
            "ticket.holding_id," +
            "ticket_name," +
            "ticket_price," +
            "ticket_capacity," +
            "COALESCE(ticket_stock_count.ticket_reservation_num,  0) AS ticketReservationNum," +
            "ticket_boundary_to_warn" +
            " FROM ticket " +
            " JOIN holding " +
            "  ON ticket.holding_id = holding.holding_id " +
            " LEFT OUTER JOIN (SELECT  " +
            "       ticket_code , SUM(ticket_reservation_num) AS ticket_reservation_num" +
            "       FROM " +
            "       ticket_reservation " +
            "       WHERE ticket_code = #{ticketCode.value} " +
            "       GROUP BY ticket_code) ticket_stock_count " +
            "   ON ticket.ticket_code = ticket_stock_count.ticket_code " +
            "WHERE " +
            " ticket.ticket_code  = #{ticketCode.value} " +
            " AND " +
            " ticket.holding_id = #{holdingId.value} " +
            " AND" +
            " holding.program_code = #{programCode.value}")
    Optional<TicketBeanMapping> findBy(@Param("programCode")ProgramCode programCode,
                                       @Param("holdingId")HoldingId holdingId,
                                       @Param("ticketCode")TicketCode ticketCode);
}
