package indi.daniel.archessm.domain.auth.model.exception;

import indi.daniel.archessm.common.message.MessageCodeConstants;
import indi.daniel.archessm.domain.shared.DomainRuntimeException;
import indi.daniel.archessm.domain.shared.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException() {
        super(MessageCodeConstants.USER_NOT_FOUND);
    }
    public UserNotFoundException(Throwable cause) {
        super(MessageCodeConstants.USER_NOT_FOUND, cause);
    }
}
