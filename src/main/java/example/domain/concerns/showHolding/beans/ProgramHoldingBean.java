package example.domain.concerns.searchHolding.beans;

import example.domain.values.holdings.HoldingId;
import example.domain.values.holdings.schedule.HoldingSchedule;
import example.domain.values.venue.Venue;

/**
 * 演目開催
 */
public class ProgramHoldingBean {
    HoldingId holdingId;
    HoldingSchedule holdingSchedule;
    Venue venue;

    public ProgramHoldingBean(HoldingId holdingId,
                              HoldingSchedule holdingSchedule,
                              Venue venue) {
        this.holdingId = holdingId;
        this.holdingSchedule = holdingSchedule;
        this.venue = venue;

    }

    public HoldingId getHoldingId() {
        return holdingId;
    }

    public HoldingSchedule getHoldingSchedule() {
        return holdingSchedule;
    }

    public Venue getVenue() {
        return venue;
    }

}
