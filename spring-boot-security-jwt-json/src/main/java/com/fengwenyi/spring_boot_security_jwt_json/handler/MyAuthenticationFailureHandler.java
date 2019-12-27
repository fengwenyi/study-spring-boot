package com.fengwenyi.spring_boot_security_jwt_json.handler;

import com.fengwenyi.spring_boot_security_jwt_json.util.MyUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
//@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String message = "";
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
//            sb.append("用户名或密码输入错误，登录失败!");
            message = e.getMessage();
        } else if (e instanceof DisabledException) {
            message = "账户被禁用，登录失败，请联系管理员!";
        } else {
//            sb.append("登录失败!");
            message = "登录失败";
        }
        MyUtils.renderError(httpServletResponse, message);
    }
}
