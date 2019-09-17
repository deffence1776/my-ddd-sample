package example.domain.values.holdings.schedule;

import example.domain.common.type.Date;

import javax.validation.Valid;

public class HoldingDay {
    @Valid
    Date value;

    public HoldingDay(Date value) {
        this.value = value;
    }



    @Override
    public String toString() {
        return value.toString();
    }

    public boolean isSameDay(Date date){
        return value.equals(date);
    }

    public boolean  isBefore(Date date){
        return value.isBefore(date);
    }

}
