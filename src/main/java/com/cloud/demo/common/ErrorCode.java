package com.cloud.demo.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {
    PARAMS_ERROR(40000, "请求参数错误"),       // 400 请求格式/参数问题
    NOT_LOGIN_ERROR(40100, "未登录"),         // 401 未认证
    NO_AUTH_ERROR(40300, "无权限"),           // 403 被拒绝
    NOT_FOUND_ERROR(40400, "请求数据不存在"),  // 404 未找到
    FORBIDDEN_ERROR(40301, "禁止访问"),       // 403 更具体的禁止
    SYSTEM_ERROR(50000, "系统内部异常"),       // 500 通用系统错误
    OPERATION_ERROR(50001, "操作失败"),        // 500 业务操作失败
    API_REQUEST_ERROR(50010, "接口调用失败");  // 500 第三方API调用失败


    private int code;
    private String message;
}
