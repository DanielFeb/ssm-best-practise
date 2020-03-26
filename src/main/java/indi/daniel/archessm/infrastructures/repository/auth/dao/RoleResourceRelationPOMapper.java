package indi.daniel.archessm.infrastructures.repository.auth.dao;

import indi.daniel.archessm.infrastructures.repository.auth.po.RoleResourceRelationPO;
import indi.daniel.archessm.infrastructures.repository.auth.po.RoleResourceRelationPOKey;

public interface RoleResourceRelationPOMapper {
    int deleteByPrimaryKey(RoleResourceRelationPOKey key);

    int insert(RoleResourceRelationPO record);

    int insertSelective(RoleResourceRelationPO record);

    RoleResourceRelationPO selectByPrimaryKey(RoleResourceRelationPOKey key);

    int updateByPrimaryKeySelective(RoleResourceRelationPO record);

    int updateByPrimaryKey(RoleResourceRelationPO record);
}