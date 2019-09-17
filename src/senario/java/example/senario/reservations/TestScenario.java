package example.senario.reservations;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import example.application.queryservices.reservation.ReservationQueryService;
import example.application.services.reservation.ReservationRegisterService;
import example.domain.concerns.reservation.exeptions.RequestedTicketNumNotSatisfiedException;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.num.RequestedTicketNum;
import example.domain.values.user.TheaterUsername;

@SpringBootTest
public class TestScenario {


    @Autowired
    ReservationRegisterService reservationRegisterService;

    @Autowired
    ReservationQueryService reservationQueryService;

    @Sql(scripts ={"/schema.sql","/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    @Transactional
    @DisplayName("事前チェックでエラーとなる")
    public void testReservation2() throws RequestedTicketNumNotSatisfiedException {
        SoftAssertions softly = new SoftAssertions();

        var requestedTicketNum = new RequestedTicketNum(10);
        var programCode = new ProgramCode("001");
        var holdingId = new HoldingId(1);
        var ticketCode = new TicketCode("T001");
        var username = new TheaterUsername("user");

        var id = reservationRegisterService.registerTicketReservation(programCode,holdingId,ticketCode, requestedTicketNum, username);
        softly.assertThat(id).isEqualTo(new TicketReservationId(1));

        var requestedTicketNum2 = new RequestedTicketNum(1);
        var result = reservationRegisterService.check(programCode, holdingId, ticketCode,requestedTicketNum2);

        softly.assertThat(result.hasErrors()).isTrue();

        softly.assertAll();
    }

    @Sql(scripts = {"/schema.sql","/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Test
    @Transactional
    @DisplayName("チケット予約成功")
    public void testReservation() throws RequestedTicketNumNotSatisfiedException {
        SoftAssertions softly = new SoftAssertions();

        var requestedTicketNum = new RequestedTicketNum(9);
        var requestedTicketNum2 = new RequestedTicketNum(1);

        var programCode = new ProgramCode("001");
        var holdingId = new HoldingId(1);
        var ticketCode = new TicketCode("T001");
        var username = new TheaterUsername("user");

        reservationRegisterService.registerTicketReservation(programCode,holdingId,ticketCode, requestedTicketNum, username);

        var checkResult = reservationRegisterService.check(programCode, holdingId, ticketCode,requestedTicketNum2);

        softly.assertThat(checkResult.hasErrors()).isFalse();

        var reservationId = reservationRegisterService.registerTicketReservation(programCode,holdingId,ticketCode, requestedTicketNum2, username);

        softly.assertThat(reservationId).isEqualTo(new TicketReservationId(2));

        var reservationBean =reservationQueryService.queryOne(reservationId,username);
        softly.assertThat(reservationBean)
                .isPresent()
                .get()
                .satisfies(r-> r.getTicketReservationId().equals(new TicketReservationId(2)));

        softly.assertAll();
    }
}
