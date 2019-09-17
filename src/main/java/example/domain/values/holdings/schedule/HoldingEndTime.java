package example.domain.values.holdings.schedule;

import example.domain.common.type.Time;

public class HoldingEndTime {

    Time value;

    public HoldingEndTime(Time time) {
        this.value = time;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
