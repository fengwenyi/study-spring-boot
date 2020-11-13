package com.fengwenyi.springbootaop.controller;

import com.fengwenyi.springbootaop.annoation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    @Log
    public String test1() {
        return "test";
    }

}
