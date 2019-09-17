package example.domain.values.tickets.capacity;


import example.domain.values.tickets.num.BoundaryToWarnNum;
import example.domain.values.tickets.num.CurrentTicketNum;
import example.domain.values.tickets.num.MaxTicketNum;
import example.domain.values.tickets.num.RequestedTicketNum;

public class TicketCapacity {
    MaxTicketNum maxCapacity;
    BoundaryToWarnNum boundaryToWarn;

    public TicketCapacity(MaxTicketNum maxCapacity, BoundaryToWarnNum boundaryToWarn) {
        this.maxCapacity = maxCapacity;
        this.boundaryToWarn = boundaryToWarn;
    }

    public TicketCapacityStatus status(CurrentTicketNum currentTicketNum) {
        if (maxCapacity.isFull(currentTicketNum)) {
            return TicketCapacityStatus.満席;
        }
        if (maxCapacity.isShouldBeWarned(boundaryToWarn, currentTicketNum)) {
            return TicketCapacityStatus.残りわずか;
        }
        return TicketCapacityStatus.空席あり;
    }

    public boolean hasRoom(CurrentTicketNum currentTicketNum,
                          RequestedTicketNum requestedSeatNum) {
        return maxCapacity.hasRoom(currentTicketNum,requestedSeatNum);
    }
}

