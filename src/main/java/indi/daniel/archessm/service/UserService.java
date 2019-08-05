package indi.daniel.archessm.service;

import indi.daniel.archessm.model.po.User;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    Integer getCurrentUserId();
}
