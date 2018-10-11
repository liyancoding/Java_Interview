package com.ly.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 16:06 2018/8/14
 * @Modified By:
 */
public class NonBlockingSynchronizationExample {

    private static AtomicInteger count = new AtomicInteger();

    public static void increase() {
        count.incrementAndGet();
    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[20];
        for(int i=0;i<20;i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10000;i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield(); // 让出线程，线程由运行状态变为就绪状态
        }

        System.out.println(count);
    }
}
