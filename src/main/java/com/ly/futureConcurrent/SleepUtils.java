package com.ly.futureConcurrent;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liyan
 * @Description: 让线程睡眠的工具类
 * @Date: Created in 15:10 2018/8/16
 * @Modified By:
 */
public class SleepUtils {
    public static final void second(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
