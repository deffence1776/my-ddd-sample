package example.infra.datasource.context.searchTicket.dao;

import example.domain.concerns.searchTicket.beans.TicketBean;
import example.domain.values.holdings.HoldingId;
import example.domain.values.tickets.capacity.CurrentTicketCapacity;
import example.domain.values.tickets.capacity.TicketCapacity;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.TicketName;
import example.domain.values.tickets.num.*;
import example.domain.values.tickets.price.TicketUnitPrice;

class TicketBeanMapping {
    TicketCode ticketCode;
    HoldingId holdingId;
    TicketName ticketName;
    TicketUnitPrice ticketUnitPrice;
    CurrentTicketCapacity currentTicketCapacity;

    public TicketBeanMapping(String ticketCode,
                             int holdingId,
                             String ticketName,
                             int  ticketPrice,
                             int ticketCapacity,
                             int ticketReservationNum,
                             int ticketBoundaryToWarn) {
        this.ticketCode = new TicketCode(ticketCode);
        this.holdingId = new HoldingId(holdingId);
        this.ticketName = new TicketName(ticketName);
        this.ticketUnitPrice = new TicketUnitPrice(ticketPrice);
        this.currentTicketCapacity = new CurrentTicketCapacity(
                new TicketCapacity(
                new MaxTicketNum(ticketCapacity),
                new BoundaryToWarnNum(ticketBoundaryToWarn)),new CurrentTicketNum(ticketReservationNum));
    }

    public TicketBean  toTicketBean(){
        return new TicketBean(ticketCode,currentTicketCapacity,ticketName,ticketUnitPrice);
    }
}
