package indi.daniel.archessm.mock.repository;

import indi.daniel.archessm.infrastructures.repository.common.dao.IdentityMapper;

public class AlwaysOneIdentityMapper implements IdentityMapper {
    @Override
    public Long getNextID(String tableName) {
        return 1L;
    }
}
