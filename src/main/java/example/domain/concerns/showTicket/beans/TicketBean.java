package example.domain.concerns.searchTicket.beans;

import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.TicketName;
import example.domain.values.tickets.capacity.CurrentTicketCapacity;
import example.domain.values.tickets.price.TicketUnitPrice;

import java.io.Serializable;


public class TicketBean implements Serializable{
    ProgramCode programCode;
    HoldingId holdingId;
    TicketCode ticketCode;
    CurrentTicketCapacity currentTicketCapacity;
    TicketName ticketName;
    TicketUnitPrice ticketUnitPrice;

    public TicketBean() {}

    public TicketBean(TicketCode ticketCode, CurrentTicketCapacity currentTicketCapacity, TicketName ticketName, TicketUnitPrice ticketUnitPrice) {
        this.ticketCode = ticketCode;
        this.currentTicketCapacity = currentTicketCapacity;
        this.ticketName = ticketName;
        this.ticketUnitPrice = ticketUnitPrice;
    }

    public TicketCode getTicketCode() {
        return ticketCode;
    }

    public CurrentTicketCapacity getCurrentTicketCapacity() {
        return currentTicketCapacity;
    }

    public TicketName getTicketName() {
        return ticketName;
    }

    public TicketUnitPrice getTicketUnitPrice() {
        return ticketUnitPrice;
    }
}
