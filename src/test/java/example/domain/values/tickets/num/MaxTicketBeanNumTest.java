package example.domain.values.tickets.num;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;
import java.util.stream.Stream;

class MaxTicketBeanNumTest {

    static Stream<Arguments> hasRoomArguments() {
        return Stream.of(
                Arguments.of(10, 9, 1,true),
                Arguments.of(10, 9, 2,false),
                Arguments.of(10, 10, 1,false),
                Arguments.of(10, 10, 0,true),
                Arguments.of(10, 11, 0,false)
        );
    }
    @ParameterizedTest
    @MethodSource("hasRoomArguments")
    void hasRoom(int maxVal, int currentVal, int requestedVal,boolean expected) {
       var result=new MaxTicketNum(maxVal).hasRoom(new CurrentTicketNum(currentVal),new RequestedTicketNum(requestedVal)) ;
       assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> isShouldBeWarnedArguments() {
        return Stream.of(
                Arguments.of(10, 4, 6,true),
                Arguments.of(10, 4, 5,false),
                Arguments.of(10, 4, 4,false)
        );
    }
    @ParameterizedTest
    @MethodSource("isShouldBeWarnedArguments")
    void isShouldBeWarned(int maxVal,int bound, int currentVal,boolean expected) {
        var result=new MaxTicketNum(maxVal).isShouldBeWarned(new BoundaryToWarnNum(bound),new CurrentTicketNum(currentVal)) ;
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> isFullArguments() {
        return Stream.of(
                Arguments.of(10, 10, true),
                Arguments.of(10, 9, false)
        );
    }
    @ParameterizedTest
    @MethodSource("isFullArguments")
    void isFull(int maxVal, int currentVal, boolean expected) {
        var result=new MaxTicketNum(maxVal).isFull(new CurrentTicketNum(currentVal)) ;
        assertThat(result).isEqualTo(expected);
    }


}