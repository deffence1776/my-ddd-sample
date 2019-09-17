package example.domain.values.tickets.num;

public class BoundaryToWarnNum {
    int value;

    public BoundaryToWarnNum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
