package example.application.queryservices.programs;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import example.domain.concerns.searchProgram.dao.ProgramDao;
import example.domain.concerns.searchProgram.beans.ProgramBeans;
import example.domain.values.programs.ProgramOpenStatus;

@Service
public class ProgramQueryService {

    final ProgramDao programDao;

    public ProgramQueryService(ProgramDao programDao) {
        this.programDao = programDao;
    }

    @Transactional(readOnly = true)
    public ProgramBeans queryAll(){
        return programDao.findByStatus(ProgramOpenStatus.公開);
    }
}
