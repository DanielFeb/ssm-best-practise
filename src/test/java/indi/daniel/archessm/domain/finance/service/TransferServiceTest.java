package indi.daniel.archessm.domain.finance.service;

import indi.daniel.archessm.domain.finance.model.account.Account;
import indi.daniel.archessm.domain.finance.model.account.AccountRepository;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistory;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistoryRepository;
import indi.daniel.archessm.domain.finance.service.transfer.TransferService;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class TransferServiceTest {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransferHistoryRepository transferHistoryRepository;
    @Autowired
    private TransferService transferService;
    @Test
    public void testTransfer() {
        Account a = new Account(accountRepository.getNextId(), Money.of(CurrencyUnit.of("CNY"), 100));
        accountRepository.create(a);
        Account b = new Account(accountRepository.getNextId(), Money.of(CurrencyUnit.of("CNY"), 100));
        accountRepository.create(b);
        TransferHistory history = transferService.transfer(a, b, Money.of(CurrencyUnit.of("CNY"), 10));
        Assert.assertEquals(90L, accountRepository.get(a.id()).getBalance().getAmountMajorLong());
        Assert.assertEquals(110L, accountRepository.get(b.id()).getBalance().getAmountMajorLong());
        Assert.assertEquals(10L, transferHistoryRepository.get(history.id()).getAmount().getAmountMajorLong());
    }
}
