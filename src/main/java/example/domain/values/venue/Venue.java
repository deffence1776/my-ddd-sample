package example.domain.values.venue;

/**
 * 会場
 */
public class Venue {
    String value;

    public Venue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
