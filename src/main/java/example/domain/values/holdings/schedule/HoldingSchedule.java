package example.domain.values.holdings.schedule;

import example.domain.common.type.Date;
import example.domain.common.type.Time;

import javax.validation.Valid;
import java.util.Map;

/**
 * 演目開催スケジュール
 */
public class HoldingSchedule {
    @Valid
    HoldingDay day;
    @Valid
    HoldingStartTime startTime;
    @Valid
    OpenTimeMargin openTimeMargin;
    @Valid
    HoldingEndTime endTime;

    public HoldingSchedule(HoldingDay day,
                           HoldingStartTime startTime,
                           OpenTimeMargin openTimeMargin,
                           HoldingEndTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.openTimeMargin = openTimeMargin;
        this.endTime = endTime;
    }

    public boolean isEqualsOrBeforeOpen(Date date, Time time){
        return  (day.isSameDay(date) || day.isBefore(date)) && (startTime.isSameTime(time) || startTime.isBefore(time));
    }

    public ScheduleStatus status(){
        if(isEqualsOrBeforeOpen(Date.today(),Time.now())) {
            return ScheduleStatus.開場前;
        }
        return ScheduleStatus.開場中;
    }


    @Override
    public String toString() {
        return show().toString();
    }

    public Map<String,String> show() {
        return Map.of("day",day.toString(),
                "startTime",startTime.toString());
    }


}
