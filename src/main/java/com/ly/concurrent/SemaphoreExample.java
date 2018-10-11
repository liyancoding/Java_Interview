package com.ly.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:58 2018/8/13
 * @Modified By:
 */
public class SemaphoreExample {
    public static void main(String[] args){

        // 只允许5个客户端线程同时访问服务器资源
        Semaphore semaphore = new Semaphore(5);

        // 创建30个线程，模拟客户端同时有30个请求线程
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        for(int i=0;i<30;i++) {
            executorService.execute(()->{
                try {
                    // 获取许可
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName() + "线程持有的信号量");

                    // 模拟客户端请求服务器资源
                    Thread.sleep(2000);
                    System.out.println("当前可用的信号量: " + semaphore.availablePermits());

                    // 访问完之后，释放信号量
                    System.out.println(Thread.currentThread().getName() + "释放信号量");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
            // 释放线程池资源
            executorService.shutdown();
    }
}
