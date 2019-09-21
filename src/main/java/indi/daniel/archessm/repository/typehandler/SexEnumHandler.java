package indi.daniel.archessm.repository.typehandler;

import indi.daniel.archessm.domain.model.user.Sex;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//TODO enhancement match all enum class
public class SexEnumHandler extends BaseTypeHandler<Sex> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, sex.toValue());
    }

    @Override
    public Sex getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return this.toEnum(resultSet.getString(columnName));
    }

    @Override
    public Sex getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return this.toEnum(resultSet.getString(columnIndex));
    }

    @Override
    public Sex getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return this.toEnum(callableStatement.getString(columnIndex));
    }

    private Sex toEnum(String value) {
        return Sex.forValue(value);
    }
}
