package indi.daniel.archessm.repository;

public interface IdentityGenerator {
    Long getNextId(String tableName);
}
