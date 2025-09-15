package com.cloud.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.pojo.entity.User;

public interface IUserService extends IService<User> {
    /**
     * @param username 用户名
     * @param password 密码
     * @param checkedPassword 密码确认
     */
    void userRegister(String username, String password, String checkedPassword);
}
