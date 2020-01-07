package indi.daniel.archessm.repository.dao;

import indi.daniel.archessm.repository.po.ResourcePO;

public interface ResourcePOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourcePO record);

    int insertSelective(ResourcePO record);

    ResourcePO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourcePO record);

    int updateByPrimaryKey(ResourcePO record);
}