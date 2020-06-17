package com.fengwenyi.study.spring_boot.application_context.contronller;

import com.fengwenyi.study.spring_boot.application_context.service.HelloWorldService;
import com.fengwenyi.study.spring_boot.application_context.util.ApplicationContextUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2020/6/17
 */
@RestController
public class HomeController {

    @GetMapping
    public String home() {
        HelloWorldService helloWorldService = (HelloWorldService) ApplicationContextUtils.getBean("HelloWorldServiceImpl");
        return helloWorldService.say();
    }

}
