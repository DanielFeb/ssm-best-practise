package indi.daniel.archessm.mock.repository;

import com.google.common.base.Preconditions;
import indi.daniel.archessm.domain.auth.model.Role;
import indi.daniel.archessm.domain.auth.model.RoleId;
import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.domain.shop.model.role.ShopRole;
import indi.daniel.archessm.infrustructures.repository.IdentityGenerator;
import indi.daniel.archessm.infrustructures.repository.TableNameConstants;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RoleRepositoryInMem implements RoleRepository {


    private final IdentityGenerator identityGenerator;
    private final Map<String, Role> roleNameMap;
    private final Map<RoleId, Role> roleIdMap;

    public RoleRepositoryInMem(IdentityGenerator identityGenerator) {
        this.identityGenerator = identityGenerator;
        this.roleIdMap = new ConcurrentHashMap<>();
        this.roleNameMap = new ConcurrentHashMap<>();
        for (ShopRole shopRole : ShopRole.values()) {
            Role role = new Role(getNextId(), shopRole.getName());
            roleIdMap.put(role.id(), role);
            roleNameMap.put(role.name(), role);
        }
    }

    @Override
    public RoleId getNextId() {
        return new RoleId(identityGenerator.getNextId(TableNameConstants.TABLE_ROLE));
    }

    @Override
    public boolean exists(RoleId id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Role> getRoles(Set<RoleId> roleIds) {
        Preconditions.checkArgument(null != roleIds);
        return roleIds.stream()
                .map(roleIdMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
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
        Preconditions.checkArgument(null != roleId);
        return roleIdMap.get(roleId);
    }

    @Override
    public Role get(String roleName) {
        return roleNameMap.get(roleName);
    }
}
