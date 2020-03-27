package indi.daniel.archessm.common.config;

import indi.daniel.archessm.domain.finance.model.account.AccountRepository;
import indi.daniel.archessm.domain.finance.model.transfer.TransferHistoryRepository;
import indi.daniel.archessm.domain.finance.service.transfer.TransferService;
import indi.daniel.archessm.infrastructures.repository.common.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.finance.AccountRepositoryMybatis;
import indi.daniel.archessm.infrastructures.repository.finance.TransferHistoryRepositoryMybatis;
import indi.daniel.archessm.infrastructures.repository.finance.dao.AccountPOMapper;
import indi.daniel.archessm.infrastructures.repository.finance.dao.TransferHistoryPOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinanceContextConfiguration {

    @Bean
    public AccountRepository accountRepository(IdentityGenerator identityGenerator, AccountPOMapper mapper) {
        return new AccountRepositoryMybatis(identityGenerator, mapper);
    }

    @Bean
    public TransferHistoryRepository transferHistoryRepository(IdentityGenerator identityGenerator, TransferHistoryPOMapper mapper) {
        return new TransferHistoryRepositoryMybatis(identityGenerator, mapper);
    }

    @Bean
    public TransferService transferService(AccountRepository accountRepository, TransferHistoryRepository transferHistoryRepository) {
        return new TransferService(accountRepository, transferHistoryRepository);
    }
}
