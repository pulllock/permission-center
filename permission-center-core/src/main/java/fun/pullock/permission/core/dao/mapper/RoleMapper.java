package fun.pullock.permission.core.dao.mapper;

import fun.pullock.permission.core.dao.model.RoleDO;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleDO row);

    int insertSelective(RoleDO row);

    RoleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleDO row);

    int updateByPrimaryKey(RoleDO row);
}