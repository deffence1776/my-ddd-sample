package example.domain.concerns.reservation.rules;

import example.domain.values.tickets.capacity.CurrentTicketCapacity;

import java.util.Optional;

public class CapacitySpec {

    public boolean isSatisfied(CurrentTicketCapacity currentTicketCapacity) {
        return currentTicketCapacity.hasRoom();
    }

    public Optional<String> check(CurrentTicketCapacity currentTicketCapacity) {
        if (!currentTicketCapacity.hasRoom()) {
            return Optional.of("満席のため、予約できません。");
        } else return Optional.empty();
    }
}
