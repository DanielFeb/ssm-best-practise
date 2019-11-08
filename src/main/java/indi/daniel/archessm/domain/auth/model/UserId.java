package indi.daniel.archessm.domain.auth.model;

import com.google.common.base.Preconditions;
import indi.daniel.archessm.domain.shared.Identity;

public class UserId extends Identity<UserId, Long> {
    public UserId(Long value) {
        super(value);
        Preconditions.checkArgument(value > 0);
    }
}
