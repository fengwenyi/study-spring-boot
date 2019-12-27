package com.fengwenyi.spring_boot_security_jwt.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/27
 */
public class TokenException extends AuthenticationException {

    public TokenException(String msg) {
        super(msg);
    }
}
