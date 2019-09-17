package example.domain.concerns.searchTicket.dao;

import example.domain.concerns.searchTicket.beans.TicketBean;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;
import example.domain.concerns.searchTicket.beans.TicketBeans;

public interface TicketBeanDao {
    TicketBeans findBy(ProgramCode programCode, HoldingId holdingId);

    TicketBean findOne(ProgramCode programCode, HoldingId holdingId, TicketCode ticketCode);
}
