package indi.daniel.archessm.infrastructures.repository.auth;

import indi.daniel.archessm.domain.auth.model.User;
import indi.daniel.archessm.domain.auth.model.UserId;
import indi.daniel.archessm.domain.auth.model.UserRepository;
import indi.daniel.archessm.domain.auth.model.exception.UserNotFoundException;
import indi.daniel.archessm.infrastructures.repository.IdentityGenerator;
import indi.daniel.archessm.infrastructures.repository.TableNameConstants;
import indi.daniel.archessm.infrastructures.repository.dao.UserPOMapper;
import indi.daniel.archessm.infrastructures.repository.po.UserPO;

public class UserRepositoryMybatis extends UserRepository {
    private final UserPOMapper userPOMapper;
    private final IdentityGenerator identityGenerator;

    public UserRepositoryMybatis(UserPOMapper userPOMapper, IdentityGenerator identityGenerator) {
        this.userPOMapper = userPOMapper;
        this.identityGenerator = identityGenerator;
    }

    @Override
    public UserId getNextId() {
        return new UserId(identityGenerator.getNextId(TableNameConstants.TABLE_USER));
    }

    @Override
    public User get(UserId userId) throws UserNotFoundException {
        assert userId != null;
        return this.get(userId.getValue());
    }

    @Override
    protected void doCreate(User user) {
        UserPO userPO = UserConverter.toPersistentObject(user);
        userPOMapper.insertSelective(userPO);
    }

    @Override
    protected void doUpdate(User user) {
        UserPO userPO = UserConverter.toPersistentObject(user);
        // TODO check no modification
        userPOMapper.updateByPrimaryKeySelective(userPO);
    }

    @Override
    public User get(Long idValue) throws UserNotFoundException {
        assert idValue != null;
        UserPO userPO = userPOMapper.selectByPrimaryKey(idValue);
        if (null == userPO) {
            throw new UserNotFoundException();
        }
        return UserConverter.toDomainObject(userPO);
    }

    @Override
    public void remove(User user) throws UserNotFoundException {
        this.remove(user.id().getValue());
    }

    @Override
    public boolean exists(UserId userId) {
        // TODO use cache
        return userPOMapper.selectByPrimaryKey(userId.getValue()) != null;
    }

    @Override
    public boolean exists(String username) {
        return !userPOMapper.selectByUsername(username).isEmpty();
    }

    private void remove(Long idValue) throws UserNotFoundException {

        assert idValue != null;
        UserPO userPO = userPOMapper.selectByPrimaryKey(idValue);
        if (null == userPO) {
            throw new UserNotFoundException();
        }
        userPOMapper.deleteByPrimaryKey(idValue);

    }
}
