package example.domain.values.tickets.price;

public class TicketUnitPrice {
    int value;

    public TicketUnitPrice(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }


    public TotalPrice total(int ticketNum) {
        return new TotalPrice(ticketNum * value);
    }

    public TotalPrice total(TicketUnitPrice other){
        return new TotalPrice(value+other.value);
    }
}
