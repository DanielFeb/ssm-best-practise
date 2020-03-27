package indi.daniel.archessm.infrastructures.repository.finance.converter;

import com.google.common.base.Converter;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistory;
import indi.daniel.archessm.infrastructures.repository.finance.po.TransferHistoryPO;

public class TransferHistoryPOConverter extends Converter<TransferHistory, TransferHistoryPO> {
    @Override
    protected TransferHistoryPO doForward(TransferHistory transferHistory) {
        TransferHistoryPO po = new TransferHistoryPO();
        po.setId(transferHistory.id());
        po.setFromAccount(transferHistory.getFromAccount());
        po.setToAccount(transferHistory.getToAccount());
        po.setAmount(transferHistory.getAmount());
        po.setTraceInformation(transferHistory);
        return po;
    }

    @Override
    protected TransferHistory doBackward(TransferHistoryPO transferHistoryPO) {
        return new TransferHistory(
                transferHistoryPO.getId(),
                transferHistoryPO.getFromAccount(),
                transferHistoryPO.getToAccount(),
                transferHistoryPO.getAmount(),
                transferHistoryPO.getTraceInformation());
    }
}
