package fun.pullock.permission.core.service;

import fun.pullock.general.model.ServiceException;
import fun.pullock.permission.core.repository.model.UserDO;
import fun.pullock.permission.core.manager.UserManager;
import fun.pullock.permission.core.model.ErrorCode;
import fun.pullock.permission.core.model.admin.LoginParam;
import fun.pullock.permission.core.session.AdminSessionUtils;
import fun.pullock.permission.core.session.SessionUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Resource
    private UserManager userManager;

    public Boolean login(LoginParam param) {
        UserDO userDO = userManager.queryByEmail(param.getEmail());
        if (userDO == null) {
            throw new ServiceException(ErrorCode.AUTH_LOGIN_USER_NOT_EXIST);
        }

        if (!param.getPassword().equals(userDO.getPassword())) {
            throw new ServiceException(ErrorCode.AUTH_LOGIN_PASSWORD_ERROR);
        }

        AdminSessionUtils.setUserId(userDO.getUserId());
        return true;
    }

    public Boolean logout(Long operatorId) {
        AdminSessionUtils.setUserId(0L);
        SessionUtils.getSession().invalidate();
        return true;
    }
}
