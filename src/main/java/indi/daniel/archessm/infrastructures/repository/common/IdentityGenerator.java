package indi.daniel.archessm.infrastructures.repository.common;

public interface IdentityGenerator {
    Long getNextId(String tableName);
}
