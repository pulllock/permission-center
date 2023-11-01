package fun.pullock.permission.core.controller.admin;

import fun.pullock.general.model.Result;
import fun.pullock.general.model.ServiceException;
import fun.pullock.permission.core.model.ErrorCode;
import fun.pullock.permission.core.model.admin.param.LoginParam;
import fun.pullock.permission.core.service.AuthService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/auth")
public class AuthController extends AdminBaseController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public Result<Boolean> login(@RequestBody LoginParam param) {
        if (param == null) {
            throw new ServiceException(ErrorCode.AUTH_LOGIN_PARAM_NULL);
        }

        if (StringUtils.isEmpty(param.getEmail())) {
            throw new ServiceException(ErrorCode.AUTH_LOGIN_EMAIL_NULL);
        }

        if (StringUtils.isEmpty(param.getPassword())) {
            throw new ServiceException(ErrorCode.AUTH_LOGIN_PASSWORD_NULL);
        }

        return new Result<>(authService.login(param));
    }

    @GetMapping("/logout")
    public Result<Boolean> logout() {
        return new Result<>(authService.logout(operator()));
    }
}
