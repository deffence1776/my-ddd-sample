package example.infra.datasource.common.typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.Assert;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractIntHandler<T> extends BaseTypeHandler<T> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i,toInt(parameter));
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        var data=rs.getInt(columnName);
        Assert.notNull(data,"data Must not null");
        return toType(data);
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        var data=rs.getInt(columnIndex);
        Assert.notNull(data,"data Must not null");
        return toType(data);
    }
    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        var data=cs.getInt(columnIndex);
        Assert.notNull(data,"data Must not null");
        return toType(data);
    }

    protected abstract int toInt(T t);
    protected abstract T toType(int i);
}
