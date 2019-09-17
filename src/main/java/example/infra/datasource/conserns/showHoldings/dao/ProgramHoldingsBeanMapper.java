package example.infra.datasource.context.searchHoldings.dao;

import org.apache.ibatis.annotations.Select;
import example.domain.values.holdings.HoldingId;
import example.domain.values.programs.ProgramCode;
import example.infra.datasource.common.annotation.DatasourceMapper;

import java.util.List;
import java.util.Optional;

@DatasourceMapper
public interface ProgramHoldingsBeanMapper {

    @Select(" SELECT " +
            "        holding_id" +
            "        ,program_code" +
            "        ,holding_startDate  " +
            "        ,holding_startTime "  +
            "        ,holding_endTime  " +
            "        ,holding_openTimeMargin  " +
            "        ,venue_name "  +
            " FROM holding " +
            " JOIN venue ON holding.venue_code = venue.venue_code " +
            " WHERE program_code = #{value} " +
            " ORDER BY holding_id")
    List<ProgramHoldingBeanMapping> findByProgramCode(ProgramCode programCode);

    @Select(" SELECT " +
            "        holding_id" +
            "        ,program_code" +
            "        ,holding_startDate  " +
            "        ,holding_startTime "  +
            "        ,holding_endTime  " +
            "        ,holding_openTimeMargin  " +
            "        ,venue_name "  +
            " FROM holding " +
            " JOIN venue ON holding.venue_code = venue.venue_code " +
            " WHERE " +
            " holding_id =#{value}")
    Optional<ProgramHoldingBeanMapping> findByHoldingId(HoldingId holdingId);

}
