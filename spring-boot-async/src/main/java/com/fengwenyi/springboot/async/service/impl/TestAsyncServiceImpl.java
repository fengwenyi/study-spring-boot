package com.fengwenyi.springboot.async.service.impl;

import com.fengwenyi.springboot.async.service.IAsyncService;
import com.fengwenyi.springboot.async.service.ITestAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Erwin Feng
 * @since 2020-11-10
 */
@Service
@Slf4j
public class TestAsyncServiceImpl implements ITestAsyncService {

    @Autowired
    @Lazy
    private IAsyncService iAsyncService;

    @Override
    public void test1() {
        log.info("test1-流程-1");
        test1Async();
        log.info("test1-流程-3");
    }

    @Override
    @Async
    public void test1Async() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test1-流程-2");
    }

    @Override
    public void test2() {
        log.info("test2-流程-1");
        test2Async();
        log.info("test2-流程-3");
    }

    @Override
    @Async
    public void test2Async() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test2-流程-2");
    }

    @Override
    public void test3() {
        log.info("test3-流程-1");
        iAsyncService.test3Async();
        log.info("test3-流程-3");
    }

    @Override
    public void test3Async() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("test3-流程-2");
    }
}
