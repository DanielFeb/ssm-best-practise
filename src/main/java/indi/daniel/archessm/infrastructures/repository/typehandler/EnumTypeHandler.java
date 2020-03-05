package indi.daniel.archessm.infrastructures.repository.typehandler;

import indi.daniel.archessm.domain.auth.model.Sex;
import indi.daniel.archessm.domain.shared.JsonSerializable;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes({Sex.class})
@MappedJdbcTypes(value = {JdbcType.INTEGER, JdbcType.TINYINT}, includeNullJdbcType = true)
public class EnumTypeHandler<T extends JsonSerializable> extends BaseTypeHandler<T> {
    private Class<T> clazz;
    public EnumTypeHandler(Class<T> clazz) {
        if (clazz == null) throw new IllegalArgumentException("Enum type handler cannot accept a null class!");
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T e, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, e.toJson());
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return this.fromJson(resultSet.getString(columnName));
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return this.fromJson(resultSet.getString(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return this.fromJson(callableStatement.getString(columnIndex));
    }

    private T fromJson(String value) {
        return (T) clazz.getEnumConstants()[0].fromJson(value);
    }
}
