package com.cloud.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private static final long serialVersionUID = 1L;
}
