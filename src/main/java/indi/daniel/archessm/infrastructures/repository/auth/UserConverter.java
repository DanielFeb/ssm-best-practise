package indi.daniel.archessm.infrastructures.repository.auth;

import indi.daniel.archessm.domain.auth.model.User;
import indi.daniel.archessm.domain.auth.model.UserId;
import indi.daniel.archessm.domain.shared.TraceInformation;
import indi.daniel.archessm.infrastructures.repository.auth.po.UserPO;

import java.util.Collections;

public class UserConverter {
    private UserConverter() { }
    public static UserPO toPersistentObject(User user) {
        UserPO userPO = new UserPO();
        userPO.setId(user.id().getValue());
        userPO.setUsername(user.username());
        userPO.setPassword(user.password());
        userPO.setNickname(user.nickname());
        userPO.setSex(user.sex());
        userPO.setBirthDate(user.birthDay());
        userPO.setAddress(user.address());
        return userPO;
    }

    public static User toDomainObject(UserPO userPO) {
        return new User(
                new UserId(userPO.getId()),
                userPO.getUsername(),
                userPO.getPassword(),
                userPO.getNickname(),
                userPO.getSex(),
                userPO.getAddress(),
                userPO.getBirthDate(),
                new TraceInformation(
                        userPO.getCreateBy(),
                        userPO.getCreateDate(),
                        userPO.getLastUpdateBy(),
                        userPO.getLastUpdateDate()),
                //TODO
                Collections.emptySet());
    }
}
