package com.ly.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description: 线程异步执行，所以结果并不是1000，如果要实现结果为1000，见AtomicIntegerExample和AtomicSynchronizedExample类。
 * @Date: Created in 16:06 2018/8/13
 * @Modified By:
 */
public class ThreadUnsafeExample {
    private  int i = 0;

    public void add() {
        i++;
    }

    public int get() {
        return i;
    }

    public static void main(String[] args) throws InterruptedException {

        ThreadUnsafeExample threadUnsafeExample = new ThreadUnsafeExample();

//        CountDownLatch countDownLatch = new CountDownLatch(1000);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<1000;i++) {
            executorService.execute(()->{
                threadUnsafeExample.add();

//                countDownLatch.countDown();
            });
        }

//        countDownLatch.await();

        executorService.shutdown();

        System.out.println(threadUnsafeExample.get());
    }
}
