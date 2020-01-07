package indi.daniel.archessm.repository.dao;

import indi.daniel.archessm.repository.po.UserRoleRelationPO;
import indi.daniel.archessm.repository.po.UserRoleRelationPOKey;

public interface UserRoleRelationPOMapper {
    int deleteByPrimaryKey(UserRoleRelationPOKey key);

    int insert(UserRoleRelationPO record);

    int insertSelective(UserRoleRelationPO record);

    UserRoleRelationPO selectByPrimaryKey(UserRoleRelationPOKey key);

    int updateByPrimaryKeySelective(UserRoleRelationPO record);

    int updateByPrimaryKey(UserRoleRelationPO record);
}