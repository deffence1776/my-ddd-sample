package example.infra.datasource.context.searchTicket.dao;

import org.springframework.stereotype.Repository;
import example.domain.concerns.searchTicket.dao.TicketBeanDao;
import example.domain.concerns.searchTicket.beans.TicketBean;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;
import example.domain.concerns.searchTicket.beans.TicketBeans;

import java.util.stream.Collectors;

@Repository
public class TicketBeanBeanDaoDatasource implements TicketBeanDao {

    TicketBeanMapper ticketBeanMapper;

    public TicketBeanBeanDaoDatasource(TicketBeanMapper ticketBeanMapper) {
        this.ticketBeanMapper = ticketBeanMapper;
    }

    @Override
    public TicketBeans findBy(ProgramCode programCode, HoldingId holdingId) {
        return new TicketBeans(
                ticketBeanMapper.findAll(programCode,holdingId)
                .stream()
                        .map(TicketBeanMapping::toTicketBean)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public TicketBean findOne(ProgramCode programCode, HoldingId holdingId, TicketCode ticketCode) {
        return ticketBeanMapper.findBy(programCode,holdingId,ticketCode)
                .orElseThrow()
                .toTicketBean();
    }
}
