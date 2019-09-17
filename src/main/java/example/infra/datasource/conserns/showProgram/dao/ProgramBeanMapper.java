package example.infra.datasource.context.searchProgram.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import example.domain.values.programs.ProgramCode;
import example.infra.datasource.common.annotation.DatasourceMapper;

import java.util.List;
import java.util.Optional;

@DatasourceMapper
interface ProgramBeanMapper {

    @Select(" SELECT " +
            "program_code," +
            "program_name," +
            "program_description," +
            "start_date," +
            "end_date   " +
            " FROM program " +
            " WHERE " +
            " program_code = #{programCode} " +
            " AND" +
            " is_open = #{status}")
    Optional<ProgramBeanMapping> findBy(@Param("programCode") ProgramCode programCode,
                                        @Param("status") boolean status);

    @Select("SELECT " +
            "program_code," +
            "program_name," +
            "program_description,  " +
            "start_date," +
            "end_date " +
            "FROM program " +
            "WHERE is_open = #{status}" +
            "ORDER BY program_code")
    List<ProgramBeanMapping> findAll(boolean status);
}
