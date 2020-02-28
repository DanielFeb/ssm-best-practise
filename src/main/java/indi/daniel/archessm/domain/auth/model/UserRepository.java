package indi.daniel.archessm.domain.auth.model;

import indi.daniel.archessm.domain.auth.model.exception.DuplicateUsernameException;
import indi.daniel.archessm.domain.auth.model.exception.UserNotFoundException;
import indi.daniel.archessm.domain.shared.DomainUtils;
import indi.daniel.archessm.domain.shared.Repository;
import indi.daniel.archessm.domain.shared.ResourceLocker;

public abstract class UserRepository implements Repository<User, UserId> {
    public void store(User user) {
        if (this.exists(user.id())) {
            doUpdate(user);
        } else {
            //检验名称重复
            if (!this.exists(user.username())) {
                String resourceUri = User.class.getName() + ".username." + user.username();
                ResourceLocker locker = DomainUtils.getResourceLocker();
                if ( locker.tryLock(resourceUri)) {
                    try {
                        if (!this.exists(user.username())) {
                            doCreate(user);
                        }
                    } finally {
                        locker.unlock(resourceUri);
                    }
                    return;
                }
            }
            throw new DuplicateUsernameException(user.username());
        }
    }

    abstract protected void doCreate(User user);
    abstract protected void doUpdate(User user);

    abstract public User get(Long idValue) throws UserNotFoundException;
    abstract public boolean exists(String username);
}
