package indi.daniel.archessm.repository.converter;

import indi.daniel.archessm.domain.model.user.User;
import indi.daniel.archessm.domain.model.user.UserId;
import indi.daniel.archessm.domain.shared.TraceInformation;
import indi.daniel.archessm.repository.po.UserPO;

public class UserConverter {
    public static UserPO deserialize(User user) {
        UserPO userPO = new UserPO();
        userPO.setId(user.id().getValue());
        userPO.setName(user.name());
        userPO.setSex(user.sex());
        userPO.setBirthDate(user.birthDay());
        userPO.setAddress(user.address());
        return userPO;
    }

    public static User serialize(UserPO userPO) {
        return new User(
                new UserId(userPO.getId()),
                userPO.getName(),
                userPO.getSex(),
                userPO.getAddress(),
                userPO.getBirthDate(),
                new TraceInformation(
                        userPO.getCreateBy(),
                        userPO.getCreateDate(),
                        userPO.getLastUpdateBy(),
                        userPO.getLastUpdateDate()));
    }
}
