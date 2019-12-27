package com.fengwenyi.spring_boot_security_jwt_json.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
@Controller
public class IndexController {

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

}
