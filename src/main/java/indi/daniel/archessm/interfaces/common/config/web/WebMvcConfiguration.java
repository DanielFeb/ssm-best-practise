package indi.daniel.archessm.interfaces.common.config.web;

import indi.daniel.archessm.interfaces.common.config.web.auth.AuthorizationInterceptor;
import indi.daniel.archessm.interfaces.common.config.web.log.PerformanceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        AuthorizationInterceptor authorizationInterceptor = new AuthorizationInterceptor();
        registry.addInterceptor(new PerformanceInterceptor());
        InterceptorRegistration registration = registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**");
        for (String path : authorizationInterceptor.getIgnorePath()) {
            registration.excludePathPatterns(path);
        }
    }
}
