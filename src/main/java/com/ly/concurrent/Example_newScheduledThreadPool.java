package com.ly.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:22 2018/8/10
 * @Modified By:
 */
public class Example_newScheduledThreadPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(Example_newScheduledThreadPool.class);

    public static void main(String[] args){
        ScheduledExecutorService sch = Executors.newScheduledThreadPool(5);

        for (int i=0;i<20;i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    LOGGER.info("执行newScheduledThreadPool方法");
                }
            };
            sch.schedule(runnable, 5000, TimeUnit.MILLISECONDS);
        }
    }
}
