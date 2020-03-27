package indi.daniel.archessm.infrastructures.repository.finance.po;

import indi.daniel.archessm.domain.finance.model.account.AccountID;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistoryID;
import indi.daniel.archessm.infrastructures.repository.common.Traceable;
import org.joda.money.Money;
import org.joda.time.DateTime;

public class TransferHistoryPO implements Traceable {
    private TransferHistoryID id;

    private AccountID fromAccount;

    private AccountID toAccount;

    private Money amount;

    private Long createBy;

    private DateTime createDate;

    private Long lastUpdateBy;

    private DateTime lastUpdateDate;

    public TransferHistoryID getId() {
        return id;
    }

    public void setId(TransferHistoryID id) {
        this.id = id;
    }

    public AccountID getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(AccountID fromAccount) {
        this.fromAccount = fromAccount;
    }

    public AccountID getToAccount() {
        return toAccount;
    }

    public void setToAccount(AccountID toAccount) {
        this.toAccount = toAccount;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Long lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public DateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(DateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}