package indi.daniel.archessm.infrastructures.repository.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        basePackages = {
                "indi.daniel.archessm.infrastructures.repository.common.dao",
                "indi.daniel.archessm.infrastructures.repository.auth.dao",
                "indi.daniel.archessm.infrastructures.repository.finance.dao",
        }
)
public class MyBatisConfiguration {
}
