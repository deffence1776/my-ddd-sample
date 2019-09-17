package example.infra.datasource.common.typehandlers.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.util.Assert;
import example.domain.common.type.Time;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.*;

@MappedJdbcTypes(JdbcType.DATE)
public class TimeTypeHandler extends BaseTypeHandler<Time> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Time parameter, JdbcType jdbcType) throws SQLException {
        LocalTime time=LocalTime.of(parameter.hour(),parameter.minute());
        ps.setTime(i,java.sql.Time.valueOf(time));
    }

    @Override
    public Time getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toTime(rs.getTime(columnName));
    }

    @Override
    public Time getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toTime(rs.getTime(columnIndex));
    }

    @Override
    public Time getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toTime(cs.getTime(columnIndex));
    }

    private Time toTime(java.sql.Time time){
        Assert.notNull(time,"Tim Must not null");
        LocalTime localTime = time.toLocalTime();
        return new Time(localTime.getHour(),localTime.getMinute());
    }
}
