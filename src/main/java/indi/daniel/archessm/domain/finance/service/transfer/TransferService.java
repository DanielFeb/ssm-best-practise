package indi.daniel.archessm.domain.finance.service.transfer;

import indi.daniel.archessm.domain.finance.model.account.Account;
import indi.daniel.archessm.domain.finance.model.account.AccountRepository;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistory;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistoryRepository;
import org.joda.money.Money;

public class TransferService {

    private final AccountRepository accountRepository;
    private final TransferHistoryRepository transferHistoryRepository;

    public TransferService(AccountRepository accountRepository, TransferHistoryRepository transferHistoryRepository) {
        this.accountRepository = accountRepository;
        this.transferHistoryRepository = transferHistoryRepository;
    }

    public TransferHistory transfer(Account fromAccount, Account toAccount, Money amount) {
        fromAccount.decreaseBalance(amount);
        toAccount.increaseBalance(amount);
        TransferHistory transferHistory = new TransferHistory(transferHistoryRepository.getNextId(), fromAccount.id(), toAccount.id(), amount);
        accountRepository.modify(fromAccount);
        accountRepository.modify(toAccount);
        transferHistoryRepository.create(transferHistory);
        return transferHistory;
    }
}
