package com.ly.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:44 2018/9/4
 * @Modified By:
 */
public class CountDownLatchDemo implements Runnable {

    static CountDownLatch countDownLatch = new CountDownLatch(10);
    static CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {
        try {
            System.out.println("开始处理数据。。。。");
            Thread.sleep(3000);
            System.out.println("处理完毕。。。");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(100);
        for (int i=0;i<10;i++) {
            es.submit(demo);
        }
        countDownLatch.await();
        System.out.println("全部处理完毕。。。。");
        es.shutdown();
    }
}
