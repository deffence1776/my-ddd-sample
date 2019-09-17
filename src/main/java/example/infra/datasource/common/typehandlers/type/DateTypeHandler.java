package example.infra.datasource.common.typehandlers.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.util.Assert;
import example.domain.common.type.Date;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.DATE)
public class DateTypeHandler extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {

        ps.setString(i,parameter.year()+"-"+parameter.month()+"-"+parameter.dateOfMonth());
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toDate(rs.getDate(columnName));
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toDate(rs.getDate(columnIndex));
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toDate(cs.getDate(columnIndex));
    }

    private Date toDate(java.sql.Date date){
        Assert.notNull(date,"Date Must not null");
        return new Date(date.toLocalDate());
    }
}
