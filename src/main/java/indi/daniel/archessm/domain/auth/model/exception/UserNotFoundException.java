package indi.daniel.archessm.domain.auth.model.exception;

import indi.daniel.archessm.domain.shared.DomainException;
import indi.daniel.archessm.common.message.MessageCodeConstants;

public class UserNotFoundException extends DomainException {
    public UserNotFoundException() {
        super(MessageCodeConstants.USER_NOT_FOUND);
    }
    public UserNotFoundException(Throwable cause) {
        super(MessageCodeConstants.USER_NOT_FOUND, cause);
    }
}
