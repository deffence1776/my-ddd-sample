package example.domain.concerns.searchProgram.dao;

import example.domain.concerns.searchProgram.beans.ProgramBean;
import example.domain.concerns.searchProgram.beans.ProgramBeans;
import example.domain.values.programs.ProgramCode;
import example.domain.values.programs.ProgramOpenStatus;

public interface ProgramDao {

    ProgramBean findBy(ProgramCode programCode,
                       ProgramOpenStatus status);

    ProgramBeans findByStatus(ProgramOpenStatus status);

}
