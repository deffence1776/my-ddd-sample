package example.domain.values.tickets.num;

public class MaxTicketNum {
    int value;

    public MaxTicketNum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public boolean hasRoom(CurrentTicketNum currentTicketNum, RequestedTicketNum requestedSeatNum) {
        return value >= currentTicketNum.value + requestedSeatNum.value;
    }

    public boolean isShouldBeWarned(BoundaryToWarnNum boundaryToWarn, CurrentTicketNum currentCapacity) {
        return (value - currentCapacity.value) <= boundaryToWarn.value;
    }

    public boolean isFull(CurrentTicketNum currentCapacity) {
        return value == currentCapacity.value;
    }

}
