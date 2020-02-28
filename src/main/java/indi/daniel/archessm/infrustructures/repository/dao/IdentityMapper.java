package indi.daniel.archessm.infrustructures.repository.dao;

public interface IdentityMapper {
    Long getNextID(String tableName);
}
