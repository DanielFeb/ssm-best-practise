package indi.daniel.archessm.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties {
    private Boolean enabled;
    private String basePackage;
    private String title;
    private String description;
    private String version;
}
