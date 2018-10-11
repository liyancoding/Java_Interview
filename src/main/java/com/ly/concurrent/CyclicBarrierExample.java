package com.ly.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:40 2018/8/13
 * @Modified By:
 */
public class CyclicBarrierExample {
    public static void main(String[] args){
        int numOfThread = 20;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numOfThread);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < numOfThread; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + " before" + " ");

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " after" + " ");
            });
        }

        executorService.shutdown();
    }
}
