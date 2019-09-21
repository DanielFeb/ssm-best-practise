package indi.daniel.archessm.domain.model.user.exception;

import indi.daniel.archessm.common.exception.DomainException;
import indi.daniel.archessm.common.message.MessageCodeConstants;

public class UserNotFoundException extends DomainException {
    public UserNotFoundException() {
        super(MessageCodeConstants.USER_NOT_FOUND);
    }
    public UserNotFoundException(Throwable cause) {
        super(MessageCodeConstants.USER_NOT_FOUND, cause);
    }
}
