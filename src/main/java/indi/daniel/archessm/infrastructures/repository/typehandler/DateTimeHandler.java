package indi.daniel.archessm.infrastructures.repository.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.time.DateTime;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DateTimeHandler extends BaseTypeHandler<DateTime> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, DateTime date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.valueOf(date.getMillis()));
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return this.toDate(resultSet.getString(columnName));
    }

    @Override
    public DateTime getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return this.toDate(resultSet.getString(columnIndex));
    }

    @Override
    public DateTime getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return this.toDate(callableStatement.getString(columnIndex));
    }

    private DateTime toDate(String value) {
        return new DateTime(Long.parseLong(value));
    }
}
