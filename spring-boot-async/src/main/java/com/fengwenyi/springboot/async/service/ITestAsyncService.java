package com.fengwenyi.springboot.async.service;

import java.util.concurrent.Future;

/**
 * @author Erwin Feng
 * @since 2020-11-10
 */
public interface ITestAsyncService {

    void test1();

    void test1Async();

    void test2Async();

    void test2();

    void test3();

    void test3Async();

    void invalidAsyncExample();

    void exampleTask();

    Future<Integer> addTask(int n);

    void noValueAsyncExample();

    int valueAsyncExample();
}
