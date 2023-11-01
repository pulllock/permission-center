package fun.pullock.permission.core.repository.mapper;

import fun.pullock.permission.core.repository.model.SystemDO;

public interface SystemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SystemDO row);

    int insertSelective(SystemDO row);

    SystemDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemDO row);

    int updateByPrimaryKey(SystemDO row);

    int updateByPrimaryKeyWithVersion(SystemDO row);

    SystemDO selectByCode(String code);
}