package com.fengwenyi.spring_boot_security_jwt.handler;

import com.fengwenyi.spring_boot_security_jwt.entity.UserEntity;
import com.fengwenyi.spring_boot_security_jwt.service.UserService;
import com.fengwenyi.spring_boot_security_jwt.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 退出
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/27
 */
@Component
public class MyLogoutHandler implements LogoutHandler {

    @Autowired
    private UserService userService;

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // 清除token
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserEntity userEntity = userService.findByUsername(userDetails.getUsername());
        TokenUtils.remove(userEntity.getUid());
    }
}
