package example.domain.values.holdings.schedule;

import java.util.List;

/**
 * 開催期間
 */
public class HoldingSchedules {

    List<HoldingSchedule> list;

    public HoldingSchedules(List<HoldingSchedule> list) {
        this.list = list;
    }

    /**
     * 開催期間の簡易表現
     */
    public String showSimple(){
        return "";
    }
}
