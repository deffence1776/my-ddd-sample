package example.domain.values.tickets.capacity;

import example.domain.values.tickets.num.CurrentTicketNum;
import example.domain.values.tickets.num.RequestedTicketNum;

public class CurrentTicketCapacity {
    TicketCapacity ticketCapacity;
    CurrentTicketNum currentTicketNum;

    public CurrentTicketCapacity(TicketCapacity ticketCapacity, CurrentTicketNum currentTicketNum) {
        this.ticketCapacity = ticketCapacity;
        this.currentTicketNum = currentTicketNum;
    }

    public boolean hasRoom(RequestedTicketNum requestedSeatNum) {
        return ticketCapacity.hasRoom(currentTicketNum,requestedSeatNum);
    }

    public boolean hasRoom() {
        return status().hasRoom();
    }

    public TicketCapacityStatus status() {
        return ticketCapacity.status(currentTicketNum);
    }
}
