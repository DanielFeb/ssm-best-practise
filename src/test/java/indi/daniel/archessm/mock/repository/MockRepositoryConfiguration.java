package indi.daniel.archessm.mock.repository;

import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.domain.auth.model.UserRepository;
import indi.daniel.archessm.repository.IdentityGenerator;
import indi.daniel.archessm.repository.dao.IdentityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MockRepositoryConfiguration {

    @Bean
    public IdentityMapper getIdentityMapper() {
        return new AlwaysOneIdentityMapper();
    }

    @Bean
    @Autowired
    public UserRepository getUserRepository(IdentityGenerator identityGenerator) {
        return new UserRepositoryInMem(identityGenerator);
    }

    @Bean
    @Autowired
    public RoleRepository getRoleRepository(IdentityGenerator identityGenerator) {
        return new RoleRepositoryInMem(identityGenerator);
    }

}
