package indi.daniel.archessm.infrastructures.repository.finance.po;

import indi.daniel.archessm.domain.finance.model.account.AccountID;
import indi.daniel.archessm.infrastructures.repository.common.Traceable;
import org.joda.money.Money;
import org.joda.time.DateTime;

public class AccountPO implements Traceable {
    private AccountID id;

    private Money balance;

    private Long createBy;

    private DateTime createDate;

    private Long lastUpdateBy;

    private DateTime lastUpdateDate;

    public AccountID getId() {
        return id;
    }

    public void setId(AccountID id) {
        this.id = id;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
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