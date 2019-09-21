package indi.daniel.archessm.common.exception;

import indi.daniel.archessm.common.message.MessageCodeConstants;
import indi.daniel.archessm.common.response.ResponseStatusCode;

public class UnexpectedServerErrorException extends ApiException {
    public UnexpectedServerErrorException(Throwable cause) {
        super(ResponseStatusCode.UNEXPECTED_SERVER_ERROR, MessageCodeConstants.UNEXPECTED_SERVER_ERROR, cause);
    }
}
