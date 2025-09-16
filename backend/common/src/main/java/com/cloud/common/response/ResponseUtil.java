package com.cloud.common.response;

import com.cloud.common.response.BaseResponse;
import com.cloud.common.response.ErrorCode;

public class ResponseUtil {
    public static BaseResponse<Void> error(int code, String message) {
        return new BaseResponse<>(code, message, null);
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(200, "success", data);
    }
}
