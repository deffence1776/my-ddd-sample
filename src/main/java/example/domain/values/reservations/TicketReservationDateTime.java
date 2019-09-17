package example.domain.values.reservations;

import example.domain.common.type.Date;
import example.domain.common.type.Time;
import example.domain.common.type.TimeStamp;

public class TicketReservationDateTime {

    TimeStamp value;

    public TicketReservationDateTime(TimeStamp value) {
        this.value=value;
    }

    public Date date(){
        return value.date();
    }

    public Time time(){
        return value.time();
    }

    public static TicketReservationDateTime now(){
        return new TicketReservationDateTime(TimeStamp.now());
    }


    @Override
    public String toString(){
        return value.toString();
    }

}
