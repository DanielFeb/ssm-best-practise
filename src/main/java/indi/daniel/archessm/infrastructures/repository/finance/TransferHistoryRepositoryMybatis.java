package indi.daniel.archessm.infrastructures.repository.finance;

import indi.daniel.archessm.domain.finance.model.transfer.TransferHistory;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistoryID;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistoryRepository;
import indi.daniel.archessm.infrastructures.repository.TableNameConstants;
import indi.daniel.archessm.infrastructures.repository.common.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.finance.converter.TransferHistoryPOConverter;
import indi.daniel.archessm.infrastructures.repository.finance.dao.TransferHistoryPOMapper;
import indi.daniel.archessm.infrastructures.repository.finance.po.TransferHistoryPO;

public class TransferHistoryRepositoryMybatis extends TransferHistoryRepository {
    private final IdentityGenerator identityGenerator;
    private final TransferHistoryPOMapper mapper;

    public TransferHistoryRepositoryMybatis(IdentityGenerator identityGenerator, TransferHistoryPOMapper mapper) {
        this.identityGenerator = identityGenerator;
        this.mapper = mapper;
    }


    private TransferHistoryPOConverter getConverter() {
        return new TransferHistoryPOConverter();
    }

    @Override
    public void doCreate(TransferHistory entity) {
        mapper.insertSelective(getConverter().convert(entity));
    }

    @Override
    public void doModify(TransferHistory entity) {
        mapper.updateByPrimaryKeySelective(getConverter().convert(entity));
    }

    @Override
    public void doRemove(TransferHistory entity) {
        mapper.deleteByPrimaryKey(entity.id());
    }

    @Override
    public String getEntityName() {
        return "转账记录";
    }

    private TransferHistoryPO getPO(TransferHistoryID id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public TransferHistory doGet(TransferHistoryID id) {
        TransferHistoryPO po = getPO(id);
        if (po != null) {
            return getConverter().reverse().convert(po);
        }
        return null;
    }

    @Override
    public TransferHistoryID getNextId() {
        return new TransferHistoryID(identityGenerator.getNextId(TableNameConstants.TABLE_FINANCE_TRANSFER_HISTORY));
    }

    @Override
    public boolean exists(TransferHistoryID id) {
        return getPO(id) != null;
    }
}
