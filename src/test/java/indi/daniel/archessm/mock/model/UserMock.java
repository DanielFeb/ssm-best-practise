package indi.daniel.archessm.mock.model;

import indi.daniel.archessm.domain.auth.model.Roles;
import indi.daniel.archessm.domain.auth.model.User;
import indi.daniel.archessm.domain.auth.model.Users;
import indi.daniel.archessm.domain.shop.model.role.ShopRole;

public class UserMock {
    private UserMock() {}
    public static User getAdmin () {
        User admin = Users.create("admin", "admin123");
        admin.addRole(Roles.getRole(ShopRole.ADMIN.getName()));
        return admin;
    }
    public static User getOwner () {
        User daniel = Users.create("daniel", "daniel123");
        daniel.addRole(Roles.getRole(ShopRole.OWNER.getName()));
        return daniel;
    }
}
