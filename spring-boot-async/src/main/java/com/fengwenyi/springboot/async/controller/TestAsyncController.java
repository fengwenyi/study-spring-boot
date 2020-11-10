package com.fengwenyi.springboot.async.controller;

import com.fengwenyi.springboot.async.service.ITestAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/test-async")
@Slf4j
public class TestAsyncController {

    @Autowired
    private ITestAsyncService iTestAsyncService;

    @GetMapping("/test1")
    public void test1() {
        log.info("test1-流程-1");
        iTestAsyncService.test1Async();
        log.info("test1-流程-3");
    }

    @GetMapping("/test2")
    public void test2() {
        iTestAsyncService.test2();
    }

    @GetMapping("/test3")
    public void test3() {
        iTestAsyncService.test3();
    }

}
