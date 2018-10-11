package com.ly.concurrent;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 15:10 2018/8/9
 * @Modified By:
 */
public class MyExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyExecutor.class);

    /**
     *  实现newCacheThreadPool()方法
     * @param re
     */
    public static void newCachedThreadPoolMethod(RunnableExecutor re) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0;i<10;i++) {
            executorService.execute(re);
        }

        executorService.shutdown();
    }

    /**
     * 实现newFixedThreadPool()方法
     * @param re
     */
    public static void newFixedThreadPoolMethod(RunnableExecutor re) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (int i =0;i<10;i++) {
            executorService.execute(re);
        }
        executorService.shutdown();
    }

    /**
     * 实现newSingleThreadPool()方法
     * @param re
     */
    public static void newSingleThreadPoolMethod(RunnableExecutor re) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i =0;i<10;i++) {
            executorService.execute(re);
        }
        executorService.shutdown();
    }

    /**
     * 实现newScheduledThreadPool()方法
     * 有问题，跑不出来，实现见Example_newScheduledThreadPool类
     * @param re
     */
    public static void newScheduledThreadPoolMethod(RunnableExecutor re) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        for (int i=0;i<10;i++) {
            scheduledExecutorService.schedule(re, 5000, TimeUnit.MILLISECONDS);
        }
        scheduledExecutorService.shutdown();
    }


}

class RunnableExecutor implements Runnable{

    private static final Logger LOGGER = LoggerFactory.getLogger(RunnableExecutor.class);

    @Override
    public void run() {
        System.out.println("Executor框架，实现异步任务执行");
    }
}
