package example.domain.concerns.reservation.exeptions;

import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;

public class RequestedTicketNumNotSatisfiedException extends Exception {
    ProgramCode programCode;
    HoldingId holdingId;
    TicketCode ticketCode;

    public RequestedTicketNumNotSatisfiedException( ProgramCode programCode, HoldingId holdingId, TicketCode ticketCode) {
        super("指定された座席数が確保できませんでした。");
        this.programCode = programCode;
        this.holdingId = holdingId;
        this.ticketCode = ticketCode;
    }

    public ProgramCode getProgramCode() {
        return programCode;
    }

    public HoldingId getHoldingId() {
        return holdingId;
    }

    public TicketCode getTicketCode() {
        return ticketCode;
    }
}
