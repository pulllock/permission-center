package fun.pullock.permission.core.repository;

import fun.pullock.permission.core.repository.mapper.UserMapper;
import fun.pullock.permission.core.repository.model.UserDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Resource
    private UserMapper userMapper;

    public UserDO queryByEmail(String email) {
        return userMapper.selectByEmail(email);
    }
}
