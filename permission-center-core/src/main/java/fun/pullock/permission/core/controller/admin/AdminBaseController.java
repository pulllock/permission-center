package fun.pullock.permission.core.controller.admin;

import fun.pullock.permission.core.session.AdminSessionUtils;

public class AdminBaseController {

    protected Long operator() {
        return AdminSessionUtils.getUserId();
    }
}
