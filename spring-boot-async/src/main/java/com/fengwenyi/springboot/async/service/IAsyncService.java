package com.fengwenyi.springboot.async.service;

import java.util.concurrent.Future;

/**
 * @author Erwin Feng
 * @since 2020-11-10
 */
public interface IAsyncService {

    void test3Async();

    void exampleTask();

    Future<Integer> addTask(int i);
}
