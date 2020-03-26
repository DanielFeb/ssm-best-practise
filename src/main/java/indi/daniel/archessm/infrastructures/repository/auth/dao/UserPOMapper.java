package indi.daniel.archessm.infrastructures.repository.auth.dao;

import indi.daniel.archessm.infrastructures.repository.auth.po.UserPO;

import java.util.List;

public interface UserPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);

    List<UserPO> selectByUsername(String username);
}