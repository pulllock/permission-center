package fun.pullock.permission.core.service;

import fun.pullock.permission.core.manager.UserManager;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    private UserManager userManager;


}
