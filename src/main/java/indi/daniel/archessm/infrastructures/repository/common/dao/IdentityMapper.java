package indi.daniel.archessm.infrastructures.repository.common.dao;

public interface IdentityMapper {
    Long getNextID(String tableName);
}
