package com.fengwenyi.springboot.async.service.impl;

import com.fengwenyi.springboot.async.service.IAsyncService;
import com.fengwenyi.springboot.async.service.ITestAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author Erwin Feng
 * @since 2020-11-10
 */
@Service
public class AsyncServiceImpl implements IAsyncService {

    @Autowired
    private ITestAsyncService iTestAsyncService;

    @Override
    @Async
    public void test3Async() {
         iTestAsyncService.test3Async();
//        test3Async2();
    }

    @Override
    @Async
    public void exampleTask() {
        iTestAsyncService.exampleTask();
    }

    @Override
    @Async
    public Future<Integer> addTask(int i) {
        return iTestAsyncService.addTask(i);
    }

    //@Override
    @Async
    public void test3Async2() {
        iTestAsyncService.test3Async();
    }
}
