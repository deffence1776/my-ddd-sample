package example.infra.datasource.context.reservation;


import org.springframework.stereotype.Repository;
import example.domain.concerns.reservation.entities.Ticket;
import example.domain.concerns.reservation.repositories.TicketRepository;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;

@Repository
class TicketRepositoryDatasource implements TicketRepository {

    example.infra.datasource.context.reservation.TicketMapper ticketMapper;

    public TicketRepositoryDatasource(example.infra.datasource.context.reservation.TicketMapper ticketMapper) {
        this.ticketMapper = ticketMapper;
    }

    @Override
    public Ticket findOne(ProgramCode programCode,
                          HoldingId holdingId,
                          TicketCode ticketCode) {
        var holding = ticketMapper.findOneHolding(programCode,holdingId).orElseThrow().programHolding;
        return ticketMapper.findOne(ticketCode)
                .orElseThrow()
                .getTicket(holding);
    }
}
