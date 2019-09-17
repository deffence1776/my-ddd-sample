package example.domain.concerns.reservation.result;

import example.domain.values.tickets.price.TotalPrice;

import java.util.List;

public class ReservationCheckResult {
    List<String> errorMessages;
    TotalPrice totalPrice;

    public ReservationCheckResult(List<String> errorMessages, TotalPrice totalPrice) {
        this.errorMessages = errorMessages;
        this.totalPrice = totalPrice;
    }

    public boolean hasErrors(){
        return !errorMessages.isEmpty();
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public TotalPrice getTotalPrice() {
        return totalPrice;
    }
}
