package indi.daniel.archessm.service;

import indi.daniel.archessm.dao.UserMapper;
import indi.daniel.archessm.model.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer getCurrentUserId() {
        return 1;
    }
}
