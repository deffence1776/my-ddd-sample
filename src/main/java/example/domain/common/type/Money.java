package example.domain.common.type;

import org.hibernate.validator.constraints.Range;

public class Money {
    @Range(min=0,max = Integer.MAX_VALUE)
    int value;

    public Money(@Range(min = 0, max = Integer.MAX_VALUE) int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int toInt() {
        return value;
    }
}
