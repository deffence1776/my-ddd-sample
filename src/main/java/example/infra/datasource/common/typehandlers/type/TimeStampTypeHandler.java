package example.infra.datasource.common.typehandlers.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.util.Assert;
import example.domain.common.type.TimeStamp;

import java.sql.*;

@MappedJdbcTypes(JdbcType.TIMESTAMP)
public class TimeStampTypeHandler extends BaseTypeHandler<TimeStamp> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TimeStamp parameter, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(i, Timestamp.valueOf(parameter.toLocalDateTime()));
    }

    @Override
    public TimeStamp getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toTimeStamp(rs.getTimestamp(columnName));
    }

    @Override
    public TimeStamp getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toTimeStamp(rs.getTimestamp(columnIndex));
    }

    @Override
    public TimeStamp getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }

    private TimeStamp toTimeStamp(java.sql.Timestamp timestamp) {
        Assert.notNull(timestamp, "timestamp Must not null");
        return new TimeStamp(timestamp.toLocalDateTime());
    }
}
