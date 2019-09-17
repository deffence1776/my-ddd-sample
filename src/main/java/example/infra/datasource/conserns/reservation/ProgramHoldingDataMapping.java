package example.infra.datasource.context.reservation;

import example.domain.common.type.Date;
import example.domain.common.type.Time;
import example.domain.concerns.reservation.entities.ProgramHolding;
import example.domain.values.holdings.HoldingId;
import example.domain.values.holdings.schedule.*;
import example.domain.values.programs.ProgramCode;

public class ProgramHoldingDataMapping {

    ProgramHolding programHolding;

    public ProgramHoldingDataMapping(String programCode,
                                     int holdingId,
                                     Date holdingStartDate,
                                     Time holdingStartTime,
                                     Time holdingEndTime,
                                     int openTimeMargin) {
        var holdingSchedule = new HoldingSchedule(
                new HoldingDay(holdingStartDate), new HoldingStartTime(holdingStartTime), new OpenTimeMargin(openTimeMargin), new HoldingEndTime(holdingEndTime));
        this.programHolding = new ProgramHolding(new ProgramCode(programCode),
                new HoldingId(holdingId), holdingSchedule);
    }
}
