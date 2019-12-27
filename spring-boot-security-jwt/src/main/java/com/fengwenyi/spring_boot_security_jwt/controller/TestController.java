package com.fengwenyi.spring_boot_security_jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/27
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
    @PreAuthorize("hasAnyRole('USER')")
    public String t1() {
        return "t1";
    }

    @RequestMapping("/t2")
    @PreAuthorize("hasAnyRole('USER') and hasRole('MANAGER')")
    public String t2() {
        return "t1";
    }

}
