package example.domain.values.tickets.num;

public class ReservedTicketNum {
    int value;

    public ReservedTicketNum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
