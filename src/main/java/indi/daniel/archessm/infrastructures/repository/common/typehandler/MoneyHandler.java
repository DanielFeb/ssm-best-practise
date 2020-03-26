package indi.daniel.archessm.infrastructures.repository.common.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoneyHandler extends BaseTypeHandler<Money> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Money money, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.valueOf(money.getAmount()));
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return this.toMoney(resultSet.getString(columnName));
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return this.toMoney(resultSet.getString(columnIndex));
    }

    @Override
    public Money getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return this.toMoney(callableStatement.getString(columnIndex));
    }

    private Money toMoney(String value) {
        return Money.ofMinor(CurrencyUnit.of("CNY"), Long.parseLong(value));
    }
}
