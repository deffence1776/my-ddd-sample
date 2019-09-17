package example.domain.values.programs;

public class ProgramDescription {
    String value;

    public ProgramDescription(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
