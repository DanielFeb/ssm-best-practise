package indi.daniel.archessm.infrastructures.repository.finance.dao;

import indi.daniel.archessm.domain.finance.model.transfer.TransferHistoryID;
import indi.daniel.archessm.infrastructures.repository.finance.po.TransferHistoryPO;

public interface TransferHistoryPOMapper {
    int deleteByPrimaryKey(TransferHistoryID id);

    int insert(TransferHistoryPO record);

    int insertSelective(TransferHistoryPO record);

    TransferHistoryPO selectByPrimaryKey(TransferHistoryID id);

    int updateByPrimaryKeySelective(TransferHistoryPO record);

    int updateByPrimaryKey(TransferHistoryPO record);
}