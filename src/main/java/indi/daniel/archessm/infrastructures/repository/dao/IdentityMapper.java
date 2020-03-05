package indi.daniel.archessm.infrastructures.repository.dao;

public interface IdentityMapper {
    Long getNextID(String tableName);
}
