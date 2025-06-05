package com.cloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.demo.Mapper.UserMapper;
import com.cloud.demo.exception.CustomException;
import com.cloud.demo.model.entity.User;
import com.cloud.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    public long userRegister(String username, String password, String checkedPassword){
        if(StringUtils.isAnyBlank(username, password, checkedPassword)){
            throw new CustomException("字符不能为空", 404);
        }

        return 0;
    }

}
