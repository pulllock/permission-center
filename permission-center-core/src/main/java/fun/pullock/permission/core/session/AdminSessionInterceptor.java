package fun.pullock.permission.core.session;

import fun.pullock.general.model.CommonErrorCode;
import fun.pullock.general.model.ServiceException;
import fun.pullock.permission.core.service.PermissionService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminSessionInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminSessionInterceptor.class);

    @Resource
    private PermissionService permissionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 非admin的链接不做校验
        String requestUri = request.getRequestURI();
        if (!requestUri.startsWith("/admin")) {
            return true;
        }

        // 校验是否登录
        Long userId = AdminSessionUtils.getUserId();
        if (userId == null || userId <= 0) {
            throw new ServiceException(CommonErrorCode.UNAUTHORIZED);
        }

        // 校验是否有权限
        // TODO
        return true;
    }
}
