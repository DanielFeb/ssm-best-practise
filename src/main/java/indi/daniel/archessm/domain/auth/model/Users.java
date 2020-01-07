package indi.daniel.archessm.domain.auth.model;

import com.google.common.base.Preconditions;
import indi.daniel.archessm.common.utils.SpringBeanUtil;
import indi.daniel.archessm.domain.auth.model.exception.UserNotFoundException;

public class Users {

    private Users() { }

    private static final UserRepository userRepository
            = SpringBeanUtil.getBean(UserRepository.class);

    public static boolean exists(User user) {
        Preconditions.checkArgument(null != user);
        return Users.exists(user.id());
    }

    public static boolean exists(UserId userId) {
        Preconditions.checkArgument(null != userId);
        return userRepository.exists(userId);
    }

    public static User create(String username, String password) {
        //TODO duplicate name check
        return new User(userRepository.getNextId(), username, password);
    }

    public static void store(User user) {
        userRepository.store(user);
    }

    public static User getByUsername(String username) throws UserNotFoundException {
        // TODO
        return null;
    }

    public static User get(UserId userId) throws UserNotFoundException {
        return userRepository.get(userId);
    }
    public static User get(Long userId) throws UserNotFoundException {
        return userRepository.get(userId);
    }

    public static void remove(User user) throws UserNotFoundException {
        userRepository.remove(user);
    }
}
