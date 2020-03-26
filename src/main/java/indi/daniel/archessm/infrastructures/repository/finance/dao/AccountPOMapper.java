package indi.daniel.archessm.infrastructures.repository.finance.dao;

import indi.daniel.archessm.domain.finance.model.account.AccountID;
import indi.daniel.archessm.infrastructures.repository.finance.po.AccountPO;

public interface AccountPOMapper {
    int deleteByPrimaryKey(AccountID id);

    int insert(AccountPO record);

    int insertSelective(AccountPO record);

    AccountPO selectByPrimaryKey(AccountID id);

    int updateByPrimaryKeySelective(AccountPO record);

    int updateByPrimaryKey(AccountPO record);
}