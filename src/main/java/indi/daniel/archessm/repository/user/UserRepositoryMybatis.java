package indi.daniel.archessm.repository.user;

import indi.daniel.archessm.domain.model.user.User;
import indi.daniel.archessm.domain.model.user.UserId;
import indi.daniel.archessm.domain.model.user.UserRepository;
import indi.daniel.archessm.domain.model.user.exception.UserNotFoundException;
import indi.daniel.archessm.repository.IdentityGenerator;
import indi.daniel.archessm.repository.TableNameConstants;
import indi.daniel.archessm.repository.converter.UserConverter;
import indi.daniel.archessm.repository.dao.UserPOMapper;
import indi.daniel.archessm.repository.po.UserPO;

public class UserRepositoryMybatis implements UserRepository {
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
    public void store(User user) {
        UserPO existingPO = userPOMapper.selectByPrimaryKey(user.id().getValue());
        UserPO userPO = UserConverter.toPersistentObject(user);
        if (null == existingPO) {
            userPOMapper.insertSelective(userPO);
        } else {
            //TODO check no modification
            userPOMapper.updateByPrimaryKeySelective(userPO);
        }
    }

    @Override
    public User get(UserId userId) throws UserNotFoundException {
        assert userId != null;
        return this.get(userId.getValue());
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
    public Boolean exists(Long idValue) {
        return userPOMapper.selectByPrimaryKey(idValue) != null;
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
