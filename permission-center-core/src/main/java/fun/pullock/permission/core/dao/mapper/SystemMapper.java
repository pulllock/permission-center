package fun.pullock.permission.core.dao.mapper;

import fun.pullock.permission.core.dao.model.SystemDO;

public interface SystemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemDO row);

    int insertSelective(SystemDO row);

    SystemDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemDO row);

    int updateByPrimaryKey(SystemDO row);
}