package indi.daniel.archessm.domain.auth.model;

import indi.daniel.archessm.common.utils.SpringBeanUtil;

public class Roles {
    private static final RoleRepository roleRepository = SpringBeanUtil.getBean(RoleRepository.class);
    public static Role getRole(String roleName) {
        return roleRepository.get(roleName);
    }

}
