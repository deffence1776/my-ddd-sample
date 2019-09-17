package example.domain.concerns.searchProgram.beans;

import example.domain.values.programs.ProgramCode;
import example.domain.values.programs.ProgramDescription;
import example.domain.values.programs.ProgramName;
import example.domain.values.programs.RunningPeriod;

public class ProgramBean {
    ProgramCode programCode;
    ProgramName programName;
    ProgramDescription programDescription;
    RunningPeriod runningPeriod;

    public ProgramBean(ProgramCode programCode, ProgramName programName, ProgramDescription programDescription, RunningPeriod runningPeriod) {
        this.programCode = programCode;
        this.programName = programName;
        this.programDescription = programDescription;
        this.runningPeriod = runningPeriod;
    }

    public ProgramCode getProgramCode() {
        return programCode;
    }

    public ProgramName getProgramName() {
        return programName;
    }

    public ProgramDescription getProgramDescription() {
        return programDescription;
    }

    public RunningPeriod getRunningPeriod() {
        return runningPeriod;
    }
}
