package example.domain.values.tickets.price;

import java.util.Arrays;

public class TotalPrice {
    int value;

    public TotalPrice(int value) {
        this.value = value;
    }
    public TotalPrice(TicketUnitPrice... prices ){
        this.value = Arrays.stream(prices)
                .map(price -> price.value)
                .reduce((v1,v2)->v1+v2)
                .orElseThrow();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public TotalPrice add(TicketUnitPrice one) {
        return new TotalPrice(value+one.value);
    }

    public TotalPrice add(TotalPrice one) {
        return new TotalPrice(value+one.value);
    }
}
