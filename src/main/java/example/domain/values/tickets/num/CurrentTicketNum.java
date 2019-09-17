package example.domain.values.tickets.num;

public class CurrentTicketNum {
    int value;

    public CurrentTicketNum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
