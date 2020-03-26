package indi.daniel.archessm.infrastructures.repository.auth;

import indi.daniel.archessm.domain.auth.model.Role;
import indi.daniel.archessm.domain.auth.model.RoleId;
import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.infrastructures.repository.common.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.TableNameConstants;

import java.util.Set;

public class RoleRepositoryMybatis implements RoleRepository {
    private final IdentityGenerator identityGenerator;

    public RoleRepositoryMybatis(IdentityGenerator identityGenerator) {
        this.identityGenerator = identityGenerator;
    }

    @Override
    public RoleId getNextId() {
        return new RoleId(identityGenerator.getNextId(TableNameConstants.TABLE_AUTH_ROLE));
    }

    @Override
    public boolean exists(RoleId id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Role> getRoles(Set<RoleId> roleIds) {
        return null;
    }

    @Override
    public void store(Role entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Role entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Role get(RoleId roleId) {
        return null;
    }

    @Override
    public Role get(String roleName) {
        return null;
    }
}
