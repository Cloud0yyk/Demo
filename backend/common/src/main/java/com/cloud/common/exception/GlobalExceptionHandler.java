package com.cloud.common.exception;

import com.cloud.common.response.BaseResponse;
import com.cloud.common.response.ErrorCode;
import com.cloud.common.response.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<Void> handleCustomException(final BusinessException e) {
        log.error("BusinessException:", e);
        return ResponseUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<Void> handleRuntimeException(final RuntimeException e) {
        log.error("RuntimeException:", e);
        return ResponseUtil.error(ErrorCode.FAIL.getCode(), e.getMessage());
    }

}
