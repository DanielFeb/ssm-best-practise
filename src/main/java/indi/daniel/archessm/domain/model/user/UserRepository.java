package indi.daniel.archessm.domain.model.user;

import indi.daniel.archessm.domain.model.user.exception.UserNotFoundException;

public interface UserRepository {
    UserId getNextId();
    void store(User user);
    User get(UserId userId) throws UserNotFoundException;
    User get(Long idValue) throws UserNotFoundException;

    void remove(User user) throws UserNotFoundException;

    Boolean exists(Long idValue);
}
