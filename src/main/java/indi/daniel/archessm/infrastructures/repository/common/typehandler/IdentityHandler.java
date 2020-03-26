package indi.daniel.archessm.infrastructures.repository.common.typehandler;

import indi.daniel.archessm.domain.finance.model.account.AccountID;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistoryID;
import indi.daniel.archessm.domain.shared.DirtyDataException;
import indi.daniel.archessm.domain.shared.Identity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@MappedTypes({AccountID.class, TransferHistoryID.class})
@MappedJdbcTypes(value = {JdbcType.BIGINT})
public class IdentityHandler<T extends Identity<T, Long>> extends BaseTypeHandler<T> {
    private Class<T> clazz;
    public IdentityHandler(Class<T> clazz) {
        if (clazz == null) throw new IllegalArgumentException("Identity type handler cannot accept a null class!");
        this.clazz = clazz;
    }
    private T getIdentity(Long value) {
        try {
            return clazz.getConstructor(Long.class).newInstance(value);
        } catch (Exception e) {
            log.error("IdentityHandler Failed to construct identity:", e);
            throw new DirtyDataException(e);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setLong(i, parameter.getValue());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getIdentity(rs.getLong(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getIdentity(rs.getLong(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getIdentity(cs.getLong(columnIndex));
    }
}