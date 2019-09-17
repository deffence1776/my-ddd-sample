package example.domain.common.type;

import java.time.LocalDateTime;

public class TimeStamp {
    LocalDateTime value;

    public TimeStamp(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static TimeStamp now() {
        return new TimeStamp(LocalDateTime.now());
    }

    public Date date() {
        return new Date(value.toLocalDate());
    }

    public Time time(){
        return new Time(value.getHour(),value.getMinute());
    }

    public LocalDateTime toLocalDateTime(){
        return value;
    }
}
