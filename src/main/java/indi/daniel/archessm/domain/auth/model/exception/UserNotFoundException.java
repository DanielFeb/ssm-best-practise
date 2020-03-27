package indi.daniel.archessm.domain.auth.model.exception;

import indi.daniel.archessm.domain.shared.repository.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {
    public UserNotFoundException() {
        super("用户");
    }
    public UserNotFoundException(Throwable cause) {
        super("用户", cause);
    }
}
