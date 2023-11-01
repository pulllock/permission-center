package fun.pullock.permission.core.model;

import fun.pullock.general.model.BaseErrorCode;

/**
 * 错误码构成：系统编码+业务模块编码+服务编码+具体错误码
 * 当前权限中心系统的编码为：1000
 * 业务模块编码：100-认证相关模块 101-业务系统模块 102-资源模块 103-用户模块 104-角色模块
 * 服务编码：1-app服务 2-管理端服务 3-rpc服务
 */
public enum ErrorCode implements BaseErrorCode {

    // 认证相关模块，管理端错误码
    AUTH_LOGIN_PARAM_NULL(100, 2, 1, "登录参数为空"),
    AUTH_LOGIN_EMAIL_NULL(100, 2, 2, "登录邮箱为空"),
    AUTH_LOGIN_PASSWORD_NULL(100, 2, 3, "登录密码为空"),
    AUTH_LOGIN_USER_NOT_EXIST(100, 2, 4, "登录用户不存在"),
    AUTH_LOGIN_PASSWORD_ERROR(100, 2, 5, "登录密码错误"),

    // 业务系统模块，管理端错误码
    SYSTEM_ADD_PARAM_NULL(101, 2, 1, "新增业务系统参数为空"),
    SYSTEM_ADD_CODE_NULL(101, 2, 2, "新增业务系统编码为空"),
    SYSTEM_ADD_NAME_NULL(101, 2, 3, "新增业务系统名称为空"),
    SYSTEM_ADD_CODE_DUPLICATE(101, 2, 4, "新增业务系统编码重复"),

    SYSTEM_UPDATE_PARAM_NULL(101, 2, 5, "更新业务系统参数为空"),
    SYSTEM_UPDATE_INVALID_ID(101, 2, 6, "更新业务系统无效的ID"),
    SYSTEM_UPDATE_NAME_NULL(101, 2, 7, "更新业务系统名称为空"),
    SYSTEM_UPDATE_FAILED(101, 2, 8, "更新业务系统失败"),
    SYSTEM_UPDATE_INVALID_VERSION(101, 2, 8, "更新业务系统无效的版本号"),
    ;

    static final int PERMISSION_CENTER_SYSTEM_CODE = 1000;

    ErrorCode(int module, int service, int errorCode, String errorMsg) {
        this.module = module;
        this.service = service;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private int module;

    private int service;

    private int errorCode;

    private String errorMsg;

    @Override
    public int getErrorCode() {
        String code = String.format("%d%d%d%d", PERMISSION_CENTER_SYSTEM_CODE, module, service, errorCode);
        return Integer.parseInt(code);
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}
