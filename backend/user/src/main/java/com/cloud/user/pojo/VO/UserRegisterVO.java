package com.cloud.user.pojo.VO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserRegisterVO {
    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    private String password;

    @NotNull(message = "密码确认不能为空")
    private String checkedPwd;
}
