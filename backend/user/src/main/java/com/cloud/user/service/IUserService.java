package com.cloud.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.user.pojo.VO.UserLoginVO;
import com.cloud.user.pojo.entity.User;
import com.cloud.user.pojo.VO.UserRegisterVO;

import javax.servlet.http.HttpSession;

public interface IUserService extends IService<User> {
    /**
     * @param userRegisterVO 用户注册信息
     */
    void userRegister(UserRegisterVO userRegisterVO);

    /**
     * @param userLoginVO 用户登录信息
     */
    void userLogin(UserLoginVO userLoginVO, HttpSession session);
}
