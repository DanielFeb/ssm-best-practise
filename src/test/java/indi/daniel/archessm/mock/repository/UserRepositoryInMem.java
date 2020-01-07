package indi.daniel.archessm.mock.repository;

import indi.daniel.archessm.domain.auth.model.User;
import indi.daniel.archessm.domain.auth.model.UserId;
import indi.daniel.archessm.domain.auth.model.UserRepository;
import indi.daniel.archessm.domain.auth.model.exception.UserNotFoundException;
import indi.daniel.archessm.repository.IdentityGenerator;
import indi.daniel.archessm.repository.TableNameConstants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepositoryInMem implements UserRepository {

    private final IdentityGenerator identityGenerator;

    private static final Map<UserId, User> userMap = new ConcurrentHashMap<>();

    public UserRepositoryInMem(IdentityGenerator identityGenerator) {
        this.identityGenerator = identityGenerator;
    }

    @Override
    public UserId getNextId() {
        return new UserId(identityGenerator.getNextId(TableNameConstants.TABLE_USER));
    }

    @Override
    public void store(User user) {
        userMap.put(user.id(), user);
    }

    @Override
    public User get(UserId userId) throws UserNotFoundException {
        User user = userMap.get(userId);
        if (null == user) throw new UserNotFoundException();
        return user;
    }

    @Override
    public User get(Long idValue) throws UserNotFoundException {
        return get(new UserId(idValue));
    }

    @Override
    public void remove(User user) throws UserNotFoundException {
        User removedUser = userMap.remove(user.id());
        if (null == removedUser) throw new UserNotFoundException();
    }

    @Override
    public Boolean exists(UserId userId) {
        return null != userMap.get(userId);
    }
}
