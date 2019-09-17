package example.domain.values.programs;

import javax.validation.constraints.NotEmpty;

public class ProgramCode {
    @NotEmpty
    String value;

    public ProgramCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
