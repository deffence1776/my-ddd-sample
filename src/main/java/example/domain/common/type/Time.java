package example.domain.common.type;

import org.hibernate.validator.constraints.Range;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Time {
    LocalTime value;
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

    public Time(@Range(min = 0, max = 24) int hour, @Range(min = 0, max = 59) int minutes) {
        value=LocalTime.of(hour,minutes);
    }

    public Time(String timeText) {
        this.value = LocalTime.parse(timeText,formatter);
    }
    public static Time now() {
        LocalTime time = LocalTime.now();
        return new Time(time.getHour(),time.getMinute());
    }

    public int hour(){
        return value.getHour();
    }
    public int minute(){
        return value.getMinute();
    }

    @Override
    public String toString() {
        return value.format(formatter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(value, time.value) &&
                Objects.equals(formatter, time.formatter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, formatter);
    }

    public boolean isBefore(Time other) {
        return value.isBefore(other.value);
    }

    public boolean isAfter(Time other) {
        return value.isAfter(other.value);
    }
}
