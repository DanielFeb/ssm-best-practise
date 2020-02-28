package indi.daniel.archessm.mock.repository;

import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.infrustructures.repository.IdentityGenerator;
import indi.daniel.archessm.infrustructures.repository.dao.IdentityMapper;
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
    public RoleRepository getRoleRepository(IdentityGenerator identityGenerator) {
        return new RoleRepositoryInMem(identityGenerator);
    }

}
