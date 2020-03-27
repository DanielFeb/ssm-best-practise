package indi.daniel.archessm.domain.finance.service.transfer;

import indi.daniel.archessm.domain.finance.model.account.AccountID;
import indi.daniel.archessm.domain.shared.cqrs.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.joda.money.Money;

@Getter
@AllArgsConstructor
@Builder
public class TransferAction implements Command<TransferAction> {
    private AccountID fromAccount;
    private AccountID toAccount;
    private Money amount;
}
