package com.ly.futureConcurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description: 1、可见性：对于一个volatile变量的读，总是能看到（任意线程）对这个volatile变量最后的写入；
 * 2、原子性：对任意单个volatile变量的读\写操作具有原子性，但类似于volatile++这种符合操作不具有原子性。
 * @Date: Created in 14:27 2018/8/16
 * @Modified By:
 */
public class VolatileExample {
    private volatile long l = 0L;

    public void set(long l) {
        l = l;
    }

    public void getAndIncrement() {
        System.out.print(l++);
    }

    public long get() {
        return l;
    }

    public static void main(String[] args){
        VolatileExample vo = new VolatileExample();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->{
            for (int i=0;i<10;i++) {
                vo.set(5);
                vo.getAndIncrement();
            }
        });

        System.out.println();

        executorService.execute(()->{
            vo.getAndIncrement();
        });

        executorService.shutdown();
    }
}
