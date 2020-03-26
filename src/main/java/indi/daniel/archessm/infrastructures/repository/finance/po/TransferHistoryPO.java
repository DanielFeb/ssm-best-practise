package indi.daniel.archessm.infrastructures.repository.finance.po;

import org.joda.money.Money;
import org.joda.time.DateTime;

public class TransferHistoryPO {
    private Long id;

    private Long fromAccount;

    private Long toAccount;

    private Money amount;

    private Long createBy;

    private DateTime createDate;

    private Long lastUpdateBy;

    private DateTime lastUpdateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Long fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Long getToAccount() {
        return toAccount;
    }

    public void setToAccount(Long toAccount) {
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