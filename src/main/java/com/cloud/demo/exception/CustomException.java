package com.cloud.demo.exception;

import lombok.Getter;

import java.io.IOException;

@Getter
public class CustomException extends RuntimeException {
    private int code;

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }
}
