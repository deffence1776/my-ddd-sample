package example.domain.values.tickets.num;

import org.hibernate.validator.constraints.Range;

public class RequestedTicketNum {
    @Range(min=1,max=10,message = "チケット枚数は1枚以上10枚以下で指定してください。")
    int value;

    public RequestedTicketNum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public boolean isCompleted(ReservedTicketNum reservedTicketNum) {
        return value == reservedTicketNum.value;
    }

    public int toInt(){
        return value;
    }
}
