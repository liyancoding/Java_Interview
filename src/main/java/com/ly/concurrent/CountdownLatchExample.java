package com.ly.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:12 2018/8/13
 * @Modified By:
 */
public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++) {
            executorService.execute(() ->{
                System.out.println(Thread.currentThread().getName() + " run first" + " ");

                // 计数器减一，直到计数器值为0。
                countDownLatch.countDown();


                try {
                    // 调用await()方法，让线程挂起，当计数器的数值为0的时候，唤醒被挂起的线程进行执行。
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run after" + " ");

            });
        }

        // 让主线程等待，当计数器的数值为0的时候，唤醒被挂起的线程进行执行。
//        countDownLatch.await();
//
//        System.out.print("end" + " ");

        executorService.shutdown();

    }
}
