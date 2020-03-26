package indi.daniel.archessm.mock.repository;

import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.infrastructures.repository.common.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.common.dao.IdentityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MockRepositoryConfiguration {

//    @Bean
//    public IdentityMapper identityMapper() {
//        return new AlwaysOneIdentityMapper();
//    }
//
//    @Bean
//    public RoleRepository roleRepository(IdentityGenerator identityGenerator) {
//        return new RoleRepositoryInMem(identityGenerator);
//    }

}
