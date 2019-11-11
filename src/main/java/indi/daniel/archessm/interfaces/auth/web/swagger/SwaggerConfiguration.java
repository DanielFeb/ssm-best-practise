package indi.daniel.archessm.interfaces.auth.web.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


// disable swagger on prod env
@Profile("! prod")
@EnableSwagger2
@Configuration
@Component
@Data
@ConfigurationProperties("swagger")
public class SwaggerConfiguration {
    private String basePackage;
    private String title;
    private String description;
    private String version;

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInfo() {

        return new ApiInfoBuilder()
                .title(this.getTitle())
                .description(this.getDescription())
                .version(this.getVersion())
                .build();

    }
}