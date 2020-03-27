package indi.daniel.archessm.domain.finance.model.transfer;

import indi.daniel.archessm.domain.finance.model.account.AccountID;
import indi.daniel.archessm.domain.shared.core.Entity;
import indi.daniel.archessm.domain.shared.repository.TraceInformation;
import indi.daniel.archessm.domain.shared.repository.Traceable;
import lombok.Getter;
import org.joda.money.Money;

import javax.annotation.Nullable;

public class TransferHistory implements Entity<TransferHistory, TransferHistoryID>, Traceable {
    private TransferHistoryID id;

    @Getter
    private AccountID fromAccount;

    @Getter
    private AccountID toAccount;

    @Getter
    private Money amount;

    private TraceInformation traceInformation;

    public TransferHistory(TransferHistoryID id, AccountID fromAccount, AccountID toAccount, Money amount, @Nullable TraceInformation traceInformation) {
        this.id = id;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.traceInformation = traceInformation == null ? TraceInformation.EMPTY_TRACE_INFORMATION: traceInformation;
    }

    public TransferHistory(TransferHistoryID id, AccountID fromAccount, AccountID toAccount, Money amount) {
        this(id, fromAccount, toAccount, amount, null);
    }

    @Override
    public TransferHistoryID id() {
        return id;
    }

    @Override
    public TraceInformation getTraceInformation() {
        return traceInformation;
    }
}
