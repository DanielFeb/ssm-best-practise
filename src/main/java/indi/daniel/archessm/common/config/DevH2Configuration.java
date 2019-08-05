package indi.daniel.archessm.common.config;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevH2Configuration {

    @Bean
    ServletRegistrationBean h2ServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebdavServlet());
        registrationBean.addUrlMappings("/h2-console/*");
        return registrationBean;
    }
}
