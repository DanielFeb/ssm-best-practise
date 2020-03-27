package indi.daniel.archessm.common.config;

import indi.daniel.archessm.domain.shared.repository.RepositoryAdvice;
import indi.daniel.archessm.infrastructures.repository.common.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.common.LocalMapIdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.common.dao.IdentityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonContextConfiguration {
    @Bean
    public IdentityGenerator identityGenerator(IdentityMapper identityMapper) {
        return LocalMapIdentityGenerator.getInstance(identityMapper);
    }
    @Bean
    public RepositoryAdvice repositoryAdvice() {
        return new RepositoryAdvice();
    }
}
