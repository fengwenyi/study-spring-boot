package com.fengwenyi.study.spring_boot.application_context.service;

import org.springframework.stereotype.Service;

/**
 * @author Erwin Feng
 * @since 2020/6/17
 */
@Service("HelloWorldServiceImpl")
public class HelloWorldService {

    public String say() {
        return "Hello World";
    }

}
