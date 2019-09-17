package example.infra.datasource.context.searchProgram.dao;

import example.domain.common.type.Date;
import example.domain.concerns.searchProgram.beans.ProgramBean;
import example.domain.values.programs.ProgramCode;
import example.domain.values.programs.ProgramDescription;
import example.domain.values.programs.ProgramName;
import example.domain.values.programs.RunningPeriod;

class ProgramBeanMapping {
    ProgramCode programCode;
    ProgramName programName;
    ProgramDescription programDescription;
    RunningPeriod runningPeriod;

    public ProgramBeanMapping(String programCode,
                              String programName,
                              String programDescription, Date startDate, Date endDate) {
        this.programCode = new ProgramCode(programCode);
        this.programName = new ProgramName(programName);
        this.programDescription =new ProgramDescription(programDescription) ;
        this.runningPeriod=new RunningPeriod(startDate,endDate);
    }

    public ProgramBean getProgramBean(){
        return new ProgramBean(programCode, programName, programDescription,runningPeriod);
    }
}
