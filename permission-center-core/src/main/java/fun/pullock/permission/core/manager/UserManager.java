package fun.pullock.permission.core.manager;

import fun.pullock.permission.core.dao.UserDao;
import fun.pullock.permission.core.dao.model.UserDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserManager {

    @Resource
    private UserDao userDao;

    public UserDO queryByEmail(String email) {
        return userDao.queryByEmail(email);
    }
}
