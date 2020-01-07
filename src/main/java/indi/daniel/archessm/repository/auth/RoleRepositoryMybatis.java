package indi.daniel.archessm.repository.auth;

import indi.daniel.archessm.domain.auth.model.Role;
import indi.daniel.archessm.domain.auth.model.RoleId;
import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.repository.IdentityGenerator;
import indi.daniel.archessm.repository.TableNameConstants;

import java.util.Set;

public class RoleRepositoryMybatis implements RoleRepository {
    private final IdentityGenerator identityGenerator;

    public RoleRepositoryMybatis(IdentityGenerator identityGenerator) {
        this.identityGenerator = identityGenerator;
    }

    @Override
    public RoleId getNextId() {
        return new RoleId(identityGenerator.getNextId(TableNameConstants.TABLE_ROLE));
    }

    @Override
    public Set<Role> getRoles(Set<RoleId> roleIds) {
        return null;
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
