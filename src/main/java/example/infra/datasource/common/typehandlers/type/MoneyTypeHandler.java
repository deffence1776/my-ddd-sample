package example.infra.datasource.common.typehandlers.type;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import example.domain.common.type.Money;
import example.infra.datasource.common.typehandlers.AbstractIntHandler;

@MappedJdbcTypes(JdbcType.INTEGER)
public class MoneyTypeHandler extends AbstractIntHandler<Money> {
    @Override
    protected int toInt(Money money) {
        return money.toInt();
    }

    @Override
    protected Money toType(int i) {
        return new Money(i);
    }
}
