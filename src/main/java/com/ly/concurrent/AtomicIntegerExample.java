package com.ly.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 21:17 2018/8/13
 * @Modified By:
 */
public class AtomicIntegerExample {
    private AtomicInteger count = new AtomicInteger();

    public void add() {
        count.incrementAndGet();
    }

    public int get() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerExample at = new AtomicIntegerExample();

        CountDownLatch countDownLatch = new CountDownLatch(1000);

        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        for (int i=0;i<1000;i++) {
            executorService.execute(()->{
                at.add();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        executorService.shutdown();

        System.out.println(at.get());
    }
}
