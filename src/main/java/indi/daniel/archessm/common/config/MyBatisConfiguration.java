package indi.daniel.archessm.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        basePackages = {
                "indi.daniel.archessm.dao"
        }
)
public class MyBatisConfiguration {
}
