package indi.daniel.archessm.infrastructures.repository.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        basePackages = {
                "indi.daniel.archessm.infrastructures.repository.dao"
        }
)
public class MyBatisConfiguration {
}
