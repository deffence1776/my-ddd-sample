package example.domain.values.tickets;

import org.hibernate.validator.constraints.Length;

public class TicketName {
    @Length(min = 1,max = 8)
    String value;

    public TicketName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
