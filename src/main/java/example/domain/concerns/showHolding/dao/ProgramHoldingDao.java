package example.domain.concerns.searchHolding.dao;

import example.domain.values.holdings.HoldingId;
import example.domain.concerns.searchHolding.beans.ProgramHoldingBean;
import example.domain.concerns.searchHolding.beans.ProgramHoldingBeans;
import example.domain.values.programs.ProgramCode;

import java.util.Optional;

public interface ProgramHoldingDao {
    ProgramHoldingBeans findBy(ProgramCode programCode);

    Optional<ProgramHoldingBean> findOne(HoldingId holdingId);
}
