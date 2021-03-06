package indi.daniel.archessm.common.message;

import indi.daniel.archessm.common.YamlPropertyLoaderFactory;
import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("message-keeper")
@PropertySource(value = "classpath:messages.yml", factory = YamlPropertyLoaderFactory.class)
@Setter
@Slf4j
public class MessageKeeper {
    private Map<String, Map<String, String>> messageMap;
    private String defaultLanguage;

    public String getMessage(String languageCode, String messageCode) {
        Map<String, String> messageCodeMap = messageMap.get(languageCode);
        String result = null;
        if (null != messageCodeMap) {
            result = messageCodeMap.get(messageCode);
        }
        if(null == result) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append("Cannot find message code ").append(messageCode)
                    .append(" in language ").append(languageCode).append("!");
            log.warn( stringBuilder.toString());
            result = messageCode;
        }
        return result;
    }
    public String getMessage(String messageCode) {
        return this.getMessage(defaultLanguage, messageCode);
    }
}
