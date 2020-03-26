package indi.daniel.archessm.infrastructures.repository.common.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty(name = "spring.datasource.driver-class-name",
        havingValue = "org.h2.Driver")
@Configuration
public class DevH2Configuration {

    @Bean
    ServletRegistrationBean h2ServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        return registrationBean;
    }
}
