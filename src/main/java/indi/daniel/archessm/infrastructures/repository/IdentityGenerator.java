package indi.daniel.archessm.infrastructures.repository;

public interface IdentityGenerator {
    Long getNextId(String tableName);
}
