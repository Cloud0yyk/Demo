package com.cloud.demo.common;

import lombok.AllArgsConstructor;

public enum ErrorCode {
    PARAMS_ERROR(400, "请求参数错误"),
    NOT_LOGIN_ERROR(401, "未登录"),
    NO_AUTH_ERROR(403, "无权限"),
    NOT_FOUND_ERROR(404, "未找到该资源"),  // 404 未找到
    FORBIDDEN_ERROR(40301, "禁止访问"),       // 403 更具体的禁止
    SYSTEM_ERROR(500, "系统内部异常"),
    OPERATION_ERROR(50001, "操作失败"),        // 500 业务操作失败
    API_REQUEST_ERROR(50010, "接口调用失败"),   // 500 第三方API调用失败
    SERVER_BUSY(503, "服务器正忙，请稍后再试");


    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
