package com.cloud.user.pojo.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {
    private Long id;

    private String username;

    private Boolean isAdmin;

    private static final long serialVersionUID = 1L;
}
