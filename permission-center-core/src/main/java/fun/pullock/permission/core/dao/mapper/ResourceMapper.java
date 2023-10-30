package fun.pullock.permission.core.dao.mapper;

import fun.pullock.permission.core.dao.model.ResourceDO;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceDO row);

    int insertSelective(ResourceDO row);

    ResourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceDO row);

    int updateByPrimaryKey(ResourceDO row);
}