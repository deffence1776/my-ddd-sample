package example.infra.datasource.context.searchHoldings.dao;

import org.springframework.stereotype.Repository;
import example.domain.concerns.searchHolding.dao.ProgramHoldingDao;
import example.domain.values.holdings.HoldingId;
import example.domain.concerns.searchHolding.beans.ProgramHoldingBean;
import example.domain.concerns.searchHolding.beans.ProgramHoldingBeans;
import example.domain.values.programs.ProgramCode;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProgramHoldingDaoDatasource implements ProgramHoldingDao {

    ProgramHoldingsBeanMapper programHoldingsBeanMapper;

    public ProgramHoldingDaoDatasource(ProgramHoldingsBeanMapper programHoldingsBeanMapper) {
        this.programHoldingsBeanMapper = programHoldingsBeanMapper;
    }

    @Override
    public ProgramHoldingBeans findBy(ProgramCode programCode) {
        var dataList = programHoldingsBeanMapper.findByProgramCode(programCode);
        var list= dataList.stream()
                .map(ProgramHoldingBeanMapping::getHolding
                ).collect(Collectors.toList());
        return new ProgramHoldingBeans(list);
    }

    @Override
    public Optional<ProgramHoldingBean> findOne(HoldingId holdingId) {
        return programHoldingsBeanMapper.findByHoldingId(holdingId).map(ProgramHoldingBeanMapping::getHolding);
    }


}
