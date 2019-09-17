package example.domain.values.holdings;

import javax.validation.constraints.Max;

public class HoldingId {
    @Max(100)
    int value;

    public HoldingId(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
