package fun.pullock.permission.core.dao.mapper;

import fun.pullock.permission.core.dao.model.UserRoleDO;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRoleDO row);

    int insertSelective(UserRoleDO row);

    UserRoleDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRoleDO row);

    int updateByPrimaryKey(UserRoleDO row);
}