package example.presentation.reservation;

import example.domain.values.tickets.num.RequestedTicketNum;
import example.fw.bindings.validations.ValueObject;

import javax.validation.constraints.NotNull;

public class TicketRequestForm {
    @ValueObject(parameterType = Integer.class)
    @NotNull
    RequestedTicketNum requestedTicketNum;

    public RequestedTicketNum getRequestedTicketNum() {
        return requestedTicketNum;
    }

    public void setRequestedTicketNum(RequestedTicketNum requestedTicketNum) {
        this.requestedTicketNum = requestedTicketNum;
    }
}
