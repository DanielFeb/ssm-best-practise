package indi.daniel.archessm.config;

import indi.daniel.archessm.domain.auth.model.RoleRepository;
import indi.daniel.archessm.domain.auth.model.UserRepository;
import indi.daniel.archessm.repository.IdentityGenerator;
import indi.daniel.archessm.repository.LocalMapIdentityGenerator;
import indi.daniel.archessm.repository.auth.RoleRepositoryMybatis;
import indi.daniel.archessm.repository.dao.UserPOMapper;
import indi.daniel.archessm.repository.auth.UserRepositoryMybatis;
import indi.daniel.archessm.repository.dao.IdentityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @Autowired
    public IdentityGenerator getIdentityGenerator(IdentityMapper identityMapper) {
        return LocalMapIdentityGenerator.getInstance(identityMapper);
    }

    @Bean
    @Autowired
    public UserRepository getUserRepository(UserPOMapper userPOMapper, IdentityGenerator identityGenerator) {
        return new UserRepositoryMybatis(userPOMapper, identityGenerator);
    }

    @Bean
    @Autowired
    public RoleRepository getRoleRepository(IdentityGenerator identityGenerator) {
        return new RoleRepositoryMybatis(identityGenerator);
    }
}
