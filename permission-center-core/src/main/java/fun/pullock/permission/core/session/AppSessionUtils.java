package fun.pullock.permission.core.session;

public class AppSessionUtils {

    private static final String USER_ID_NAME = "User-Id";

    public static Long getUserId() {
        Object value = SessionUtils.getAttribute(USER_ID_NAME);
        if (value == null) {
            return null;
        }

        return Long.parseLong(String.valueOf(value));
    }

    public static void setUserId(Long userId) {
        SessionUtils.setAttribute(USER_ID_NAME, userId);
    }
}
