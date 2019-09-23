package indi.daniel.archessm.interfaces.web.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final AuthorizationInterceptor authorizationInterceptor;

    @Autowired
    public WebMvcConfiguration(AuthorizationInterceptor authorizationInterceptor) {
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(authorizationInterceptor)
                .addPathPatterns("/**");
        for (String path : authorizationInterceptor.getIgnorePath()) {
            registration.excludePathPatterns(path);
        }
    }
}
