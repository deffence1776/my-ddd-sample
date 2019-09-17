package example.domain.values.holdings.schedule;

import org.hibernate.validator.constraints.Range;

/**
 * 開場時間。
 * 開演からどのくらい前かを指定する
 */
public class OpenTimeMargin {
    @Range(min = 0,max = 5)
    int hour;
    @Range(min = 0,max = 59)
    int minus;

    public OpenTimeMargin(@Range(min = 0, max = 5) int hour, @Range(min = 0, max = 59) int minus) {
        this.hour = hour;
        this.minus = minus;
    }
    public OpenTimeMargin(@Range(min = 0,max=359)int minutes) {
        this.hour = minutes/60;
        this.minus = minus%60;
    }
}
