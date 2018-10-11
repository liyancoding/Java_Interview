package com.ly.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:46 2018/8/11
 * @Modified By:
 */
public class ReentrantLockExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReentrantLockExample.class);

    private ReentrantLock lock = new ReentrantLock();

    public void func1() {
        lock.lock();
        try{
            for (int i=0;i<150;i++) {
                System.out.print(i+" ");
            }
        }finally {
            lock.unlock(); // 若是不释放锁，会导致死锁
        }
    }

    public static void main(String[] args){

        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(() -> reentrantLockExample.func1());
        ex.execute(() -> reentrantLockExample.func1());
        LOGGER.info("OK");
    }
}
