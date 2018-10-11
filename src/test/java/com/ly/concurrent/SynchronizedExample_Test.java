package com.ly.concurrent;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 15:30 2018/8/10
 * @Modified By:
 */
public class SynchronizedExample_Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizedExample_Test.class);

    SynchronizedExample synchronizedExample = new SynchronizedExample();
    SynchronizedExample synchronizedExample1 = new SynchronizedExample();

    @Test
    public void test_func1(){

        // 两个线程调用了一个对象的同步代码块，因此这两个线程同步执行输出。
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedExample.func1());
        executorService.execute(() -> synchronizedExample.func1());
        LOGGER.info("OK");
    }

    @Test
    public void test_func11() {

        // 两个线程调用了不同对象的同步代码块，因此这两个线程执行的时候不会同步。异步交叉执行输出。
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedExample.func1());
        executorService.execute(() -> synchronizedExample1.func1());
        LOGGER.info("OK");
    }

    @Test
    public void test_func2() {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedExample.func2());
        executorService.execute(() -> synchronizedExample1.func2());
        LOGGER.info("OK");
    }

    @Test
    public void test_func3() {

        // 当synchronized修饰一个static方法的时候，作用于整个类，
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedExample.func3());
        executorService.execute(() -> synchronizedExample1.func3());
        LOGGER.info("OK");
    }

    @Test
    public void test_func4() {

        // 当synchronized修饰一个类的时候，如果两个线程调用同一个类的不同对象的时候，也会同步执行输出。
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedExample.func4());
        executorService.execute(() -> synchronizedExample1.func4());
        LOGGER.info("OK");
    }
}