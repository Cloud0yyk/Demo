package com.cloud.demo.controller;


import com.cloud.demo.common.BaseResponse;
import com.cloud.demo.common.ResponseUtil;
import com.cloud.demo.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "用户模块", description = "用户相关接口")
public class UserController {
    @Autowired
    private IUserService userService;

    @PutMapping("/register")
    @Operation(summary = "用户注册", description = "传入用户名和密码")
    public BaseResponse<Long> userRegister(@RequestParam String username, @RequestParam String password, @RequestParam String checkedPassword) {
        userService.userRegister(username, password, checkedPassword);
        return ResponseUtil.success(null);
    }

}
