package indi.daniel.archessm.domain.auth.model;

import indi.daniel.archessm.domain.auth.model.exception.DuplicateUsernameException;
import indi.daniel.archessm.domain.auth.model.exception.UserNotFoundException;
import indi.daniel.archessm.domain.shared.*;
import indi.daniel.archessm.domain.shared.repository.EntityAlreadyExistsException;
import indi.daniel.archessm.domain.shared.repository.Repository;
import indi.daniel.archessm.domain.shared.repository.ResourceLocker;

import java.util.function.Consumer;

public abstract class UserRepository implements Repository<User, UserId> {
    public static final String ENTITY_NAME = "用户";

    public void store(User user) {
        if (this.exists(user.id())) {
            lockResourceAddDoOperation(user, this::doModify);
        } else {
            lockResourceAddDoOperation(user, this::doCreate);
        }
    }

    abstract protected void doCreate(User user);
    abstract protected void doModify(User user);

    abstract public User get(Long idValue) throws UserNotFoundException;
    abstract public boolean exists(String username);

    @Override
    public void create(User user) {
        if (this.exists(user.id())) {
            throw new EntityAlreadyExistsException(ENTITY_NAME);
        } else {
            lockResourceAddDoOperation(user, this::doCreate);
        }
    }

    private void lockResourceAddDoOperation(User user, Consumer<User> operation) {
        //检验名称重复
        if (!this.exists(user.username())) {
            String resourceUri = User.class.getName() + ".username." + user.username();
            ResourceLocker locker = DomainUtils.getResourceLocker();
            if ( locker.tryLock(resourceUri)) {
                try {
                    if (!this.exists(user.username())) {
                        operation.accept(user);
                    }
                } finally {
                    locker.unlock(resourceUri);
                }
                return;
            }
        }
        throw new DuplicateUsernameException(user.username());
    }

    @Override
    public void modify(User user) {
        if (this.exists(user.id())) {
            lockResourceAddDoOperation(user, this::doModify);
        } else {
            throw new UserNotFoundException();
        }
    }
}
