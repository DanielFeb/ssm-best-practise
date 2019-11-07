package indi.daniel.archessm.common;

import indi.daniel.archessm.domain.model.user.UserRepository;
import indi.daniel.archessm.repository.IdentityGenerator;
import indi.daniel.archessm.repository.LocalMapIdentityGenerator;
import indi.daniel.archessm.repository.dao.UserPOMapper;
import indi.daniel.archessm.repository.user.UserRepositoryMybatis;
import indi.daniel.archessm.repository.dao.IdentityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class ApplicationConfiguration {
    @Resource
    private UserPOMapper userPOMapper;
    @Resource
    private IdentityMapper identityMapper;


    @Bean
    public IdentityGenerator getIdentityGenerator() {
        return LocalMapIdentityGenerator.getInstance(identityMapper);
    }

    @Bean
    @Autowired
    public UserRepository getUserRepository(IdentityGenerator identityGenerator) {
        return new UserRepositoryMybatis(userPOMapper, identityGenerator);
    }
}
