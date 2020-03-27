package indi.daniel.archessm.domain.auth.model;


import indi.daniel.archessm.domain.shared.repository.Repository;

import java.util.Set;

public interface RoleRepository extends Repository<Role, RoleId> {
    Set<Role> getRoles(Set<RoleId> roleIds);
    Role get(String roleName);
}
