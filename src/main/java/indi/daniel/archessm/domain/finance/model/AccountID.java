package indi.daniel.archessm.domain.finance.model;

import indi.daniel.archessm.domain.shared.Identity;

public class AccountID extends Identity<AccountID, Long> {
    public AccountID(Long value) {
        super(value);
    }
}
