package com.cloud.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.demo.Mapper.UserMapper;
import com.cloud.demo.common.ErrorCode;
import com.cloud.demo.exception.BusinessException;
import com.cloud.demo.pojo.entity.User;
import com.cloud.demo.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    // 加密字符
    private final String SALT = "cloud";

    public void userRegister(String username, String password, String checkedPassword){
        if(StringUtils.isAnyBlank(username, password, checkedPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不能为空！");
        }

        if(!password.equals(checkedPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "二次输入的密码不一致！");
        }


        synchronized (username.intern()){
            // 账号名非重复
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", username);
            long count = this.baseMapper.selectCount(queryWrapper);
            if(count > 0){
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "账号重复");
            }

            // 密码加密
            String encryptPassword = DigestUtils.md5DigestAsHex((SALT + password).getBytes());

            // 插入
            User user = new User();
            user.setUsername(username);
            user.setPassword(encryptPassword);

            boolean saveResult = this.save(user);
            if(!saveResult) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库注册错误！");
            }
        }
    }

}
