package indi.daniel.archessm.infrastructures.repository.finance;

import indi.daniel.archessm.domain.finance.model.account.Account;
import indi.daniel.archessm.domain.finance.model.account.AccountID;
import indi.daniel.archessm.domain.finance.model.account.AccountRepository;
import indi.daniel.archessm.infrastructures.repository.TableNameConstants;
import indi.daniel.archessm.infrastructures.repository.common.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.finance.converter.AccountPOConverter;
import indi.daniel.archessm.infrastructures.repository.finance.dao.AccountPOMapper;
import indi.daniel.archessm.infrastructures.repository.finance.po.AccountPO;

public class AccountRepositoryMybatis extends AccountRepository {
    private final IdentityGenerator identityGenerator;
    private final AccountPOMapper accountMapper;

    private AccountPOConverter getConverter() {
        return new AccountPOConverter();
    }

    public AccountRepositoryMybatis(IdentityGenerator identityGenerator, AccountPOMapper accountMapper) {
        this.identityGenerator = identityGenerator;
        this.accountMapper = accountMapper;
    }

    @Override
    public void doCreate(Account entity) {
        accountMapper.insertSelective(getConverter().convert(entity));
    }

    @Override
    public void doModify(Account entity) {
        accountMapper.updateByPrimaryKeySelective(getConverter().convert(entity));
    }

    @Override
    public void doRemove(Account entity) {
        accountMapper.deleteByPrimaryKey(entity.id());
    }

    @Override
    public String getEntityName() {
        return "账户";
    }

    @Override
    public Account doGet(AccountID id) {
        AccountPO po = getAccountPO(id);
        if(po != null) {
            return getConverter().reverse().convert(po);
        }
        return null;
    }

    private AccountPO getAccountPO(AccountID id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public AccountID getNextId() {
        return new AccountID(identityGenerator.getNextId(TableNameConstants.TABLE_FINANCE_ACCOUNT));
    }

    @Override
    public boolean exists(AccountID id) {
        return getAccountPO(id) != null;
    }
}
