package indi.daniel.archessm.common.config;

import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.domain.auth.model.UserRepository;
import indi.daniel.archessm.infrastructures.repository.auth.dao.UserPOMapper;
import indi.daniel.archessm.infrastructures.repository.common.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.common.LocalMapIdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.auth.RoleRepositoryMybatis;
import indi.daniel.archessm.infrastructures.repository.auth.UserRepositoryMybatis;
import indi.daniel.archessm.infrastructures.repository.common.dao.IdentityMapper;
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
