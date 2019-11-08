package indi.daniel.archessm.domain.auth.model;

import com.google.common.base.Preconditions;
import indi.daniel.archessm.domain.shared.Identity;

public class RoleId extends Identity<RoleId, Long> {
    public RoleId(Long value) {
        super(value);
        Preconditions.checkArgument(value >= 0);
    }
}
