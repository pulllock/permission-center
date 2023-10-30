package fun.pullock.permission.core.dao.mapper;

import fun.pullock.permission.core.dao.model.RoleResourceDO;

public interface RoleResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleResourceDO row);

    int insertSelective(RoleResourceDO row);

    RoleResourceDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleResourceDO row);

    int updateByPrimaryKey(RoleResourceDO row);
}