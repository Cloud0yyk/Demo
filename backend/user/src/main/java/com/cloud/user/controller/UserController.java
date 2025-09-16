package com.cloud.user.controller;


import com.cloud.user.common.BaseResponse;
import com.cloud.user.common.ResponseUtil;
import com.cloud.user.pojo.VO.UserLoginVO;
import com.cloud.user.pojo.VO.UserRegisterVO;
import com.cloud.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Tag(name = "用户模块", description = "用户相关接口")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @Operation(summary = "用户注册")
    public BaseResponse<Void> userRegister(@Valid UserRegisterVO userRegisterVO) {
        userService.userRegister(userRegisterVO);
        return ResponseUtil.success(null);
    }

    @PostMapping("/register")
    @Operation(summary = "用户登录")
    public BaseResponse<Void> userLogin(@Valid UserLoginVO userLoginVO, HttpSession session) {
        userService.userLogin(userLoginVO, session);
        return ResponseUtil.success(null);
    }
}
