package example.application.queryservices.tickets;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import example.domain.concerns.searchTicket.dao.TicketBeanDao;
import example.domain.concerns.searchTicket.beans.TicketBean;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;
import example.domain.concerns.searchTicket.beans.TicketBeans;
@Service
public class TicketQueryService {

    TicketBeanDao ticketBeanDao;

    public TicketQueryService(TicketBeanDao ticketBeanDao) {
        this.ticketBeanDao = ticketBeanDao;
    }

    public TicketBeans queryTickets(ProgramCode programCode, HoldingId holdingId){
        return ticketBeanDao.findBy(programCode, holdingId);
    }

    @Transactional(readOnly = true)
    public TicketBean queryTicket(ProgramCode programCode, HoldingId holdingId, TicketCode ticketCode) {

        return ticketBeanDao.findOne(programCode, holdingId, ticketCode);
    }
}
