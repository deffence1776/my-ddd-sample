package example.domain.values.tickets;

public class TicketCode {
    String value;

    public TicketCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
