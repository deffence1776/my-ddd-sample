package example.infra.datasource.context.searchProgram.dao;

import org.springframework.stereotype.Repository;
import example.domain.concerns.searchProgram.dao.ProgramDao;
import example.domain.concerns.searchProgram.beans.ProgramBean;
import example.domain.values.programs.ProgramCode;
import example.domain.concerns.searchProgram.beans.ProgramBeans;
import example.domain.values.programs.ProgramOpenStatus;

import java.util.stream.Collectors;

@Repository
class ProgramBeanDaoDatasource implements ProgramDao {

    ProgramBeanMapper programBeanMapper;

    public ProgramBeanDaoDatasource(ProgramBeanMapper programBeanMapper) {
        this.programBeanMapper = programBeanMapper;
    }

    @Override
    public ProgramBean findBy(ProgramCode programCode,ProgramOpenStatus status) {
        return programBeanMapper.findBy(programCode,status.isOpen())
                .orElseThrow()
                .getProgramBean();
    }

    @Override
    public ProgramBeans findByStatus(ProgramOpenStatus status) {
        return new ProgramBeans(
                programBeanMapper
                .findAll(status.isOpen())
                .stream()
                .map(ProgramBeanMapping::getProgramBean)
                .collect(Collectors.toList()));
    }
}
