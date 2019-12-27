package com.fengwenyi.spring_boot_security_jwt.service;

import com.fengwenyi.spring_boot_security_jwt.bean.AuthenticationUser;
import com.fengwenyi.spring_boot_security_jwt.entity.UserEntity;
import com.fengwenyi.spring_boot_security_jwt.util.MyUserUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
@Service
public class UserService {

    public UserEntity findByUsername(String username) {
        MyUserUtils.set();
        return MyUserUtils.getByUsername(username);
    }

    // 当前登录用户
    public UserEntity getCurrentLoginUser() {
        AuthenticationUser loginUser = MyUserUtils.getLoginUser();

        // 这里假设用用户名查询
        // 真实环境会用uid查询
        UserDetails userDetails = (UserDetails) loginUser;
        UserEntity userEntity = MyUserUtils.getByUsername(userDetails.getUsername());
        return userEntity;
    }

}
