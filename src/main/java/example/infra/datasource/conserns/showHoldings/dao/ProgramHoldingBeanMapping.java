package example.infra.datasource.context.searchHoldings.dao;

import example.domain.concerns.searchHolding.beans.ProgramHoldingBean;
import example.domain.values.holdings.HoldingId;
import example.domain.values.holdings.schedule.*;
import example.domain.values.programs.ProgramCode;
import example.domain.common.type.Date;
import example.domain.common.type.Time;
import example.domain.values.venue.Venue;

public class ProgramHoldingBeanMapping {
    HoldingId holdingId;
    ProgramCode programCode;
    HoldingDay holdingDay;
    HoldingStartTime holdingStartTime;
    HoldingEndTime holdingEndTime;
    OpenTimeMargin openTimeMargin;
    Venue venue;

    public ProgramHoldingBeanMapping(int holdingId,
                                     String programCode,
                                     Date holdingStartDate,
                                     Time holdingStartTime,
                                     Time holdingEndTime,
                                     int openTimeMargin,
                                     String venueName) {
        this.holdingId =new HoldingId(holdingId);
        this.programCode = new ProgramCode(programCode);
        this.holdingDay = new HoldingDay(holdingStartDate);
        this.holdingStartTime = new HoldingStartTime(holdingStartTime);
        this.holdingEndTime = new HoldingEndTime(holdingEndTime);
        this.openTimeMargin = new OpenTimeMargin(openTimeMargin);
        this.venue=new Venue(venueName);
    }

    public ProgramHoldingBean getHolding(){
        return new ProgramHoldingBean(holdingId
                , new HoldingSchedule(holdingDay,
                holdingStartTime,
                openTimeMargin, holdingEndTime)
                , venue);
    }

}
