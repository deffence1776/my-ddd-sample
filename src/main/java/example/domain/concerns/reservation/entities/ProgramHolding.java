package example.domain.concerns.reservation.entities;

import example.domain.values.holdings.HoldingId;
import example.domain.values.holdings.schedule.HoldingSchedule;
import example.domain.values.programs.ProgramCode;

public class ProgramHolding {
    ProgramCode programCode;
    HoldingId holdingId;
    HoldingSchedule holdingSchedule;

    public ProgramHolding(ProgramCode programCode, HoldingId holdingId, HoldingSchedule holdingSchedule) {
        this.programCode = programCode;
        this.holdingId = holdingId;
        this.holdingSchedule = holdingSchedule;
    }
}
