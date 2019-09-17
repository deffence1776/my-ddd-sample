package example.domain.values.programs;

import example.domain.common.type.Date;

public class RunningPeriod {
    Date startDate;
    Date endDate;

    public RunningPeriod(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RunningStatus status(Date currentDate){
        if (startDate.isAfter(currentDate)) {
            return RunningStatus.上演前;
        }

        if (endDate.equals(currentDate) || endDate.isAfter(currentDate)) {
            return RunningStatus.上演中;
        }

        return RunningStatus.上演終了;
    }
    public RunningStatus status() {
        return status(Date.today());
    }

    @Override
    public String toString() {
        return startDate.toString() +"〜"+endDate.toString();
    }
}
