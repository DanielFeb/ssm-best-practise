package indi.daniel.archessm.infrastructures.repository.finance.converter;

import com.google.common.base.Converter;
import indi.daniel.archessm.domain.finance.model.account.Account;
import indi.daniel.archessm.infrastructures.repository.finance.po.AccountPO;

public class AccountPOConverter extends Converter<Account, AccountPO> {
    @Override
    protected AccountPO doForward(Account account) {
        AccountPO po = new AccountPO();
        po.setId(account.id());
        po.setBalance(account.getBalance());
        po.setTraceInformation(account);
        return po;
    }

    @Override
    protected Account doBackward(AccountPO accountPO) {
        return new Account(
                accountPO.getId(),
                accountPO.getBalance(),
                accountPO.getTraceInformation());
    }
}
