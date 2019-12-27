package com.fengwenyi.spring_boot_security_jwt;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
public class MyTests {

    @Test
    public void generatePassword() {
        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);
    }
}
