package example.domain.values.user;

public class TheaterUsername {
    String value;

    public TheaterUsername(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isEquals(TheaterUsername user) {
        return user.value.equals(value);
    }
}
