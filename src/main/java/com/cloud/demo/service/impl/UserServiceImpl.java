package com.cloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.demo.Mapper.UserMapper;
import com.cloud.demo.common.ErrorCode;
import com.cloud.demo.exception.BusinessException;
import com.cloud.demo.pojo.entity.User;
import com.cloud.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public long userRegister(String username, String password, String checkedPassword){
        if(StringUtils.isAnyBlank(username, password, checkedPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不能为空！");
        }

        if(!password.equals(checkedPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "二次输入的密码不一致！");
        }

        User user = User.builder()
                        .username(username)
                        .password(password)
                        .build();

        boolean res = this.save(user);
        if(!res){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库注册错误！");
        }

        return user.getUserId();
    }

}
