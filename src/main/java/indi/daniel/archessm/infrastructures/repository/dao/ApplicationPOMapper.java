package indi.daniel.archessm.infrastructures.repository.dao;

import indi.daniel.archessm.infrastructures.repository.po.ApplicationPO;

public interface ApplicationPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApplicationPO record);

    int insertSelective(ApplicationPO record);

    ApplicationPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApplicationPO record);

    int updateByPrimaryKey(ApplicationPO record);
}