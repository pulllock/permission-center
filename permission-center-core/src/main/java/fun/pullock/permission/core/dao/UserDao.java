package fun.pullock.permission.core.dao;

import fun.pullock.permission.core.dao.mapper.UserMapper;
import fun.pullock.permission.core.dao.model.UserDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Resource
    private UserMapper userMapper;

    public UserDO queryByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
}
