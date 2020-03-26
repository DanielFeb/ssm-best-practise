package indi.daniel.archessm.infrastructures.repository.auth.dao;

import indi.daniel.archessm.infrastructures.repository.auth.po.RolePO;

public interface RolePOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RolePO record);

    int insertSelective(RolePO record);

    RolePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePO record);

    int updateByPrimaryKey(RolePO record);
}