package indi.daniel.archessm.infrastructures.repository.finance.dao;

import indi.daniel.archessm.infrastructures.repository.finance.po.AccountPO;

public interface AccountPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AccountPO record);

    int insertSelective(AccountPO record);

    AccountPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AccountPO record);

    int updateByPrimaryKey(AccountPO record);
}