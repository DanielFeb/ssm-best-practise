package indi.daniel.archessm.infrastructures.repository.finance.dao;

import indi.daniel.archessm.infrastructures.repository.finance.po.TransferHistoryPO;

public interface TransferHistoryPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransferHistoryPO record);

    int insertSelective(TransferHistoryPO record);

    TransferHistoryPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransferHistoryPO record);

    int updateByPrimaryKey(TransferHistoryPO record);
}