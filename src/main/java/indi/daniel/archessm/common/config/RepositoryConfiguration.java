package indi.daniel.archessm.common.config;

import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.domain.auth.model.UserRepository;
import indi.daniel.archessm.infrastructures.repository.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.LocalMapIdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.auth.RoleRepositoryMybatis;
import indi.daniel.archessm.infrastructures.repository.auth.UserRepositoryMybatis;
import indi.daniel.archessm.infrastructures.repository.dao.IdentityMapper;
import indi.daniel.archessm.infrastructures.repository.dao.UserPOMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public IdentityGenerator identityGenerator(IdentityMapper identityMapper) {
        return LocalMapIdentityGenerator.getInstance(identityMapper);
    }

    @Bean
    public UserRepository userRepository(UserPOMapper userPOMapper, IdentityGenerator identityGenerator) {
        return new UserRepositoryMybatis(userPOMapper, identityGenerator);
    }

    @Bean
    public RoleRepository roleRepository(IdentityGenerator identityGenerator) {
        return new RoleRepositoryMybatis(identityGenerator);
    }
}
