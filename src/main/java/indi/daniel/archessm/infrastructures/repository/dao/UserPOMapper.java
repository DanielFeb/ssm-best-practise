package indi.daniel.archessm.infrastructures.repository.dao;

import indi.daniel.archessm.infrastructures.repository.po.UserPO;

import java.util.List;

public interface UserPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPO record);

    int insertSelective(UserPO record);

    UserPO selectByPrimaryKey(Long id);

    List<UserPO> selectByUsername(String username);

    int updateByPrimaryKeySelective(UserPO record);

    int updateByPrimaryKey(UserPO record);
}