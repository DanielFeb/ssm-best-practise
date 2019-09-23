package indi.daniel.archessm.repository.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        basePackages = {
                "indi.daniel.archessm.repository.dao"
        }
)
public class MyBatisConfiguration {
}
