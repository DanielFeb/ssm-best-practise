package indi.daniel.archessm.infrustructures.repository;

public interface IdentityGenerator {
    Long getNextId(String tableName);
}
