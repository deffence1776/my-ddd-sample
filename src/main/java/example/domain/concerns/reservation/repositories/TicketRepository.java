package example.domain.concerns.reservation.repositories;

import example.domain.concerns.reservation.entities.Ticket;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;

public interface TicketRepository {

    Ticket findOne(ProgramCode programCode, HoldingId holdingId, TicketCode ticketCode);
}
