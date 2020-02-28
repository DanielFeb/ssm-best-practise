package indi.daniel.archessm.infrustructures.repository.dao;

import indi.daniel.archessm.infrustructures.repository.po.ApplicationPO;

public interface ApplicationPOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApplicationPO record);

    int insertSelective(ApplicationPO record);

    ApplicationPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApplicationPO record);

    int updateByPrimaryKey(ApplicationPO record);
}