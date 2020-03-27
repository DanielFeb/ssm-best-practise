package indi.daniel.archessm.domain.auth.model;

import com.google.common.base.Preconditions;
import indi.daniel.archessm.domain.shared.core.Entity;
import org.apache.commons.lang3.StringUtils;

public class Role implements Entity<Role, RoleId> {
    private RoleId id;
    private String name;

    public Role(RoleId id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @Override
    public RoleId id() {
        return id;
    }

    public void setId(RoleId id) {
        Preconditions.checkArgument(null != id);
        this.id = id;
    }

    public String name() {
        return name;
    }

    private void setName(String name) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(name));
        this.name = name;
    }

}
