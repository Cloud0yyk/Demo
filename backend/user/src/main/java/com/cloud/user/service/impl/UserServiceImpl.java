package com.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.Mapper.UserMapper;
import com.cloud.user.common.ErrorCode;
import com.cloud.user.exception.BusinessException;
import com.cloud.user.pojo.VO.UserLoginVO;
import com.cloud.user.pojo.entity.User;
import com.cloud.user.pojo.VO.UserRegisterVO;
import com.cloud.user.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    // 加密字符
    private final String SALT = "cloud";

    public void userRegister(UserRegisterVO userRegisterVO) {
        String username = userRegisterVO.getUsername();
        String password = userRegisterVO.getPassword();
        String checkPwd = userRegisterVO.getCheckedPwd();

        if(StringUtils.isAnyBlank(username, password, checkPwd)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不能为空！");
        }

        if(!password.equals(checkPwd)){
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

    public void userLogin(UserLoginVO userLoginVO, HttpSession session) {
        User loginUser = new User();
        loginUser.setUsername(userLoginVO.getUsername());
        loginUser.setPassword(DigestUtils.md5DigestAsHex((SALT + userLoginVO.getPassword()).getBytes()));
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername, userLoginVO.getUsername());
        lambdaQueryWrapper.eq(User::getPassword, userLoginVO.getPassword());
        User user = this.baseMapper.selectOne(lambdaQueryWrapper);
        if(user == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户名或密码错误！");
        }
        session.setAttribute("user", user);
    }

}
