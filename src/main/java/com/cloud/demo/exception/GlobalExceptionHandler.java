package com.cloud.demo.exception;

import com.cloud.demo.common.BaseResponse;
import com.cloud.demo.common.ErrorCode;
import com.cloud.demo.common.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<Void> handleCustomException(final BusinessException e) {
        log.error("BusinessException:", e);
        return ResponseUtil.error(ErrorCode.OPERATION_ERROR, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<Void> handleRuntimeException(final RuntimeException e) {
        log.error("RuntimeException:", e);
        return ResponseUtil.error(ErrorCode.SYSTEM_ERROR, e.getMessage());
    }

}
