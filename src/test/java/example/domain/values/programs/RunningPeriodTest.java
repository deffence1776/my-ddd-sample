package example.domain.values.programs;

import org.junit.jupiter.api.Test;
import example.domain.common.type.Date;
import static org.assertj.core.api.Assertions.*;

class RunningPeriodTest {

    @Test
    void status() {
        var start = new Date(2019,10,1);
        var end = new Date(2019,10,31);
        var today= new Date(2019,10,10);
        var sut =new RunningPeriod(start,end);

        var result =sut.status(today);
        assertThat(result).isEqualTo(RunningStatus.上演中);
    }
}