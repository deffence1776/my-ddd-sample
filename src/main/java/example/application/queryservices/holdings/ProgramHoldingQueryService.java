package example.application.queryservices.holdings;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import example.domain.concerns.searchHolding.dao.ProgramHoldingDao;
import example.domain.concerns.searchHolding.beans.ProgramHoldingBeans;
import example.domain.values.programs.ProgramCode;

@Service
public class ProgramHoldingQueryService {

    ProgramHoldingDao programHoldingDao;

    public ProgramHoldingQueryService(ProgramHoldingDao programHoldingDao) {
        this.programHoldingDao = programHoldingDao;
    }

    @Transactional(readOnly = true)
    public ProgramHoldingBeans queryHoldings(ProgramCode programCode){
        return programHoldingDao.findBy(programCode);
    }
}
