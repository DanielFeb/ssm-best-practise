package indi.daniel.archessm.common.message;

import indi.daniel.archessm.common.utils.SpringBeanUtil;
import org.springframework.stereotype.Component;

@Component
public class MessageFactory {
    private MessageFactory() { }
    public static String getMessageByCode(String messageCode) {
        return SpringBeanUtil.getBean(MessageKeeper.class).getMessage(messageCode);
    }
    public static String getMessageByCode(String languageCode, String messageCode) {
        return SpringBeanUtil.getBean(MessageKeeper.class).getMessage(languageCode, messageCode);
    }
}
