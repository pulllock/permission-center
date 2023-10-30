package fun.pullock.permission.core.model;

import fun.pullock.general.model.BaseErrorCode;

/**
 * 错误码构成：系统编码+业务模块编码+服务编码+具体错误码
 * 当前权限中心系统的编码为：1000
 * 业务模块编码：100-业务系统模块 101-资源模块 102-用户模块 103-角色模块
 * 服务编码：1-app服务 2-管理端服务 3-rpc服务
 */
public enum ErrorCode implements BaseErrorCode {

    // 业务系统模块，管理端错误码
    SYSTEM_ADD_PARAM_NULL(100, 2, 1, "新增业务系统参数为空"),
    SYSTEM_ADD_CODE_NULL(100, 2, 2, "新增业务系统编码为空"),
    SYSTEM_ADD_NAME_NULL(100, 2, 3, "新增业务系统名称为空"),
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
