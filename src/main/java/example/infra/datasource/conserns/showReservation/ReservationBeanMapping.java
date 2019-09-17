package example.infra.datasource.context.searchReservation;

import example.domain.concerns.searchReservation.beans.ReservationBean;
import example.domain.common.type.TimeStamp;
import example.domain.values.reservations.TicketReservationDateTime;
import example.domain.values.reservations.TicketReservationId;
import example.domain.values.tickets.TicketCode;
import example.domain.values.tickets.num.ReservedTicketNum;

public class ReservationBeanMapping {

    TicketReservationId reservationId;
    TicketCode ticketCode;
    TicketReservationDateTime ticketReservationDateTime;
    ReservedTicketNum ticketReservationNum;

    public ReservationBeanMapping(int reservationId, String ticketCode, TimeStamp ticketReservationDateTime, int ticketReservationNum, String theaterUsername) {
        this.reservationId = new TicketReservationId(reservationId);
        this.ticketCode = new TicketCode(ticketCode);
        this.ticketReservationDateTime = new TicketReservationDateTime(ticketReservationDateTime);
        this.ticketReservationNum = new ReservedTicketNum(ticketReservationNum);
    }

    public ReservationBean getReservation(){
        return new ReservationBean(ticketCode,reservationId,ticketReservationNum, ticketReservationDateTime);
    }
}
