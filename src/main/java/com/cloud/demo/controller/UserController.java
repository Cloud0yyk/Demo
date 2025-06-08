package com.cloud.demo.controller;


import com.cloud.demo.common.BaseResponse;
import com.cloud.demo.common.ResponseUtil;
import com.cloud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/register")
    public BaseResponse<Long> userRegister(@RequestParam String username, @RequestParam String password, @RequestParam String checkedPassword) {
        Long res = userService.userRegister(username, password, checkedPassword);
        return ResponseUtil.success(res);
    }

}
