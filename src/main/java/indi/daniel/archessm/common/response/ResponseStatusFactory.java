package indi.daniel.archessm.common.response;

import indi.daniel.archessm.common.message.MessageFactory;

public class ResponseStatusFactory {
    public static ResponseStatus get(ResponseStatusCode code, String messageCode) {
        return get(code, messageCode, code.getDescription());
    }
    public static ResponseStatus get(ResponseStatusCode code, String messageCode, String detail) {
        return new ResponseStatus(code, MessageFactory.getMessageByCode(messageCode), detail);
    }
}
