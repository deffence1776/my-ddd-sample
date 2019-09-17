package example.domain.concerns.reservation.rules;

import example.domain.values.holdings.schedule.HoldingSchedule;

import java.util.Optional;

import static example.domain.values.holdings.schedule.ScheduleStatus.開場中;
import static example.domain.values.holdings.schedule.ScheduleStatus.開場前;

public class ScheduleSpec {

    public boolean isSatisfied(HoldingSchedule holdingSchedule){
        return holdingSchedule.status().equals(開場前)|| holdingSchedule.status().equals(開場中);
    }

    public Optional<String> check(HoldingSchedule holdingSchedule){
        if(!(holdingSchedule.status().equals(開場前)|| holdingSchedule.status().equals(開場中))){
            return Optional.of("既に開演している為、予約できません。");
        }
        else return Optional.empty();
    }
}
