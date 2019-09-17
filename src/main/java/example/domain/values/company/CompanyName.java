package example.domain.values.company;

public class CompanyName {
    String value;

    public CompanyName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
