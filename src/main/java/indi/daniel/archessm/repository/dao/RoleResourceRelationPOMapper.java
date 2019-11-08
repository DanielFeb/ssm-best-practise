package indi.daniel.archessm.repository.dao;

import indi.daniel.archessm.repository.po.RoleResourceRelationPO;
import indi.daniel.archessm.repository.po.RoleResourceRelationPOKey;

public interface RoleResourceRelationPOMapper {
    int deleteByPrimaryKey(RoleResourceRelationPOKey key);

    int insert(RoleResourceRelationPO record);

    int insertSelective(RoleResourceRelationPO record);

    RoleResourceRelationPO selectByPrimaryKey(RoleResourceRelationPOKey key);

    int updateByPrimaryKeySelective(RoleResourceRelationPO record);

    int updateByPrimaryKey(RoleResourceRelationPO record);
}