package indi.daniel.archessm.domain.model.user;

import indi.daniel.archessm.domain.shared.Identity;

public class UserId extends Identity<UserId, Long> {
    public UserId(Long value) {
        super(value);
    }
}
