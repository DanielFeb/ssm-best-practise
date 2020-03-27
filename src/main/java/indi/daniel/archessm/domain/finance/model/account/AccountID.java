package indi.daniel.archessm.domain.finance.model.account;

import indi.daniel.archessm.domain.shared.core.Identity;

public class AccountID extends Identity<AccountID, Long> {
    public AccountID(Long value) {
        super(value);
    }
}
