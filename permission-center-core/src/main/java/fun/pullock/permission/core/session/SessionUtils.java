package fun.pullock.permission.core.session;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtils {

    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static Object getAttribute(String name) {
        return getSession().getAttribute(name);
    }

    public static String getSessionId() {
        return getSession().getId();
    }

    public static void setAttribute(String name, Object value) {
        getSession().setAttribute(name, value);
    }
}
