package indi.daniel.archessm.domain.finance.model.account;

import com.google.common.base.Preconditions;
import indi.daniel.archessm.domain.shared.core.DomainRuntimeException;
import indi.daniel.archessm.domain.shared.core.Entity;
import indi.daniel.archessm.domain.shared.repository.TraceInformation;
import indi.daniel.archessm.domain.shared.repository.Traceable;
import lombok.Getter;
import org.joda.money.BigMoney;
import org.joda.money.Money;

import javax.annotation.Nullable;

public class Account implements Entity<Account, AccountID>, Traceable {
    private AccountID id;
    @Getter
    private Money balance;

    private TraceInformation traceInformation;

    public Account(AccountID id, Money balance) {
        this(id, balance, null);
    }

    public Account(AccountID id, Money balance, @Nullable TraceInformation traceInformation) {
        this.id = id;
        this.balance = balance;
        this.traceInformation = traceInformation == null ? TraceInformation.EMPTY_TRACE_INFORMATION : traceInformation;
    }

    @Override
    public AccountID id() {
        return id;
    }

    @Override
    public TraceInformation getTraceInformation() {
        return traceInformation;
    }

    public void increaseBalance(Money delta) {
        Preconditions.checkNotNull(delta);
        this.balance = this.balance.plus(delta);
    }

    public void decreaseBalance(Money delta) {
        Preconditions.checkNotNull(delta);
        if (this.balance.compareTo(() -> BigMoney.of(delta)) > 0) {
            this.balance = this.balance.minus(delta);
        } else {
             throw new DomainRuntimeException("账户余额不足！");
        }
    }
}
