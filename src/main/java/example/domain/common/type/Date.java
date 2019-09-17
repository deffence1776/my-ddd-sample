package example.domain.common.type;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Date {
    @NotNull
    LocalDate value;

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");

    public Date(LocalDate value) {
        this.value = value;
    }

    public Date(String dateText) {
       value=LocalDate.parse(dateText,formatter);
    }

    public Date(int year ,int month,int dayOfMonth) {
        value=LocalDate.of(year,month,dayOfMonth);
    }

    public static Date today() {
        return new Date(LocalDate.now());
    }

    @Override
    public String toString() {
        return value.format(formatter);
    }

    public int year(){
        return value.getYear();
    }
    public int month(){
        return value.getMonthValue();
    }
    public int dateOfMonth() {
        return value.getDayOfMonth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Objects.equals(value, date.value) &&
                Objects.equals(formatter, date.formatter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, formatter);
    }

    public boolean isBefore(Date other) {
        return value.isBefore(other.value);
    }

    public boolean isAfter(Date other) {
        return value.isAfter(other.value);
    }
}
