package com.ly.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:25 2018/8/13
 * @Modified By:
 */
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for(int i=0;i<100;i++) {
                    Thread.sleep(20);
                    res += i;
                }
                return res;
            }
        });

        Thread thread = new Thread(ft);
        thread.start();

        // 利用Lambda表达式匿名重写run()方法
        Thread otherThread = new Thread(()->{
            System.out.println("other thread is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        otherThread.start();
        System.out.println(ft.get());
    }
}
