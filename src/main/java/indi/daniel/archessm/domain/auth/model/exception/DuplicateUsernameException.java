package indi.daniel.archessm.domain.auth.model.exception;

import indi.daniel.archessm.common.message.MessageCodeConstants;
import indi.daniel.archessm.domain.shared.DomainRuntimeException;

public class DuplicateUsernameException extends DomainRuntimeException {
    public DuplicateUsernameException(String username) {
        super(username, null);
    }

    public DuplicateUsernameException(String username, Throwable cause) {
        super(MessageCodeConstants.DUPLICATE_USER_NAME + username, cause);
    }
}
