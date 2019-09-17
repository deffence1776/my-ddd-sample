package example.domain.values.holdings.schedule;

import example.domain.common.type.Time;

import javax.validation.Valid;

public class HoldingStartTime {
    @Valid
    Time value;

    public HoldingStartTime(Time value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public boolean isSameTime(Time time){
        return value.equals(time);
    }

    public boolean isBefore(Time time){
        return value.isBefore(time);
    }
}