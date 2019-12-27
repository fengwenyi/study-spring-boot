package com.fengwenyi.spring_boot_security_jwt_json.handler;

import com.fengwenyi.spring_boot_security_jwt_json.util.MyUserUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    protected Logger logger = LoggerFactory.getLogger(MyLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("logout user {}",authentication.getName());
        //登出后清除用户缓存信息
        MyUserUtils.remove(authentication.getName());
    }
}
