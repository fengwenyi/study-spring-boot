package com.fengwenyi.springboot.async.service.impl;

import com.fengwenyi.springboot.async.service.IAsyncService;
import com.fengwenyi.springboot.async.service.ITestAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @Override
    public void invalidAsyncExample() {
        log.info("流程-1-{}", Thread.currentThread().getId());
        invalidAsyncTask();
        log.info("流程-3-{}", Thread.currentThread().getId());
    }

    @Override
    public void exampleTask() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("耗时任务-2-{}", Thread.currentThread().getId());
    }

    @Override
    public Future<Integer> addTask(int n) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("计算任务-{}", Thread.currentThread().getId());
        return AsyncResult.forValue(n + 2);
    }

    @Override
    public void noValueAsyncExample() {
        log.info("流程-1-{}", Thread.currentThread().getId());
        iAsyncService.exampleTask();
        log.info("流程-3-{}", Thread.currentThread().getId());
    }

    @Override
    public int valueAsyncExample() {
        int result = 0;

        long startTime = System.currentTimeMillis();

        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<Integer> future = iAsyncService.addTask(i);
            futureList.add(future);
        }

        for (Future<Integer> f : futureList) {
            Integer value = null;
            try {
                value = f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            if (value != null)
                result += value;
        }

        long endTime = System.currentTimeMillis();

        log.info("耗时 {} s", (endTime - startTime) / 1000D);

        return result;
    }

    @Async
    public void invalidAsyncTask() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("流程-2-{}", Thread.currentThread().getId());
    }
}
