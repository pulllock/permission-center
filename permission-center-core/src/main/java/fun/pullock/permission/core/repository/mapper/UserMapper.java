package fun.pullock.permission.core.repository.mapper;

import fun.pullock.permission.core.repository.model.UserDO;

public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UserDO row);

    int insertSelective(UserDO row);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserDO row);

    int updateByPrimaryKey(UserDO row);

    UserDO selectByEmail(String email);
}