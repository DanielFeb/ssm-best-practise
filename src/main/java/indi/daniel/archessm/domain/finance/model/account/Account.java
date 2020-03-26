package indi.daniel.archessm.domain.finance.model.account;

import indi.daniel.archessm.domain.shared.Entity;
import indi.daniel.archessm.domain.shared.TraceInformation;
import indi.daniel.archessm.domain.shared.Traceable;
import lombok.Getter;
import org.joda.money.Money;

public class Account implements Entity<Account, AccountID>, Traceable {
    private AccountID id;
    @Getter
    private Money balance;

    private TraceInformation traceInformation;

    @Override
    public AccountID id() {
        return id;
    }

    @Override
    public TraceInformation getTraceInformation() {
        return traceInformation;
    }
}
