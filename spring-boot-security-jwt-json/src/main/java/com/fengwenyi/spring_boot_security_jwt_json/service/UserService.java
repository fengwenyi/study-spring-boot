package com.fengwenyi.spring_boot_security_jwt_json.service;

import com.fengwenyi.spring_boot_security_jwt_json.entity.UserEntity;
import com.fengwenyi.spring_boot_security_jwt_json.util.MyUserUtils;
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

}
