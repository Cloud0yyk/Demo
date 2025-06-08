package com.cloud.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.demo.pojo.entity.User;

public interface UserService extends IService<User> {
    long userRegister(String username, String password, String checkedPassword);
}
