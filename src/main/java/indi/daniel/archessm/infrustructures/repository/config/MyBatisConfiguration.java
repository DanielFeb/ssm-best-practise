package indi.daniel.archessm.infrustructures.repository.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        basePackages = {
                "indi.daniel.archessm.infrustructures.repository.dao"
        }
)
public class MyBatisConfiguration {
}
