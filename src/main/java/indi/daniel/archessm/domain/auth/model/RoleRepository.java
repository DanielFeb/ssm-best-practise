package indi.daniel.archessm.domain.auth.model;

import java.util.Set;

public interface RoleRepository {
    RoleId getNextId();
    Set<Role> getRoles(Set<RoleId> roleIds);
    Role get(RoleId roleId);
    Role get(String roleName);
}
