package fun.pullock.permission.core.manager;

import fun.pullock.permission.core.repository.UserRepository;
import fun.pullock.permission.core.repository.model.UserDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserManager {

    @Resource
    private UserRepository userRepository;

    public UserDO queryByEmail(String email) {
        return userRepository.queryByEmail(email);
    }
}
