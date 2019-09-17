package example.domain.concerns.searchTicket.beans;

import java.util.List;

public class TicketBeans {
    List<TicketBean> list;
    public TicketBeans(List<TicketBean> list) {
        this.list = list;
    }
    public List<TicketBean> getList() {
        return list;
    }
}
