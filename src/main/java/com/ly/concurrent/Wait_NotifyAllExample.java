package com.ly.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:02 2018/8/11
 * @Modified By:
 */
public class Wait_NotifyAllExample {
    public synchronized void func1() {
        System.out.println("启动线程1，先执行");
        notify(); // 唤醒被挂起的线程2
    }

    public synchronized void func2() {
        try {
            wait(); // 挂起线程，释放锁。
            System.out.println("启动线程2，后执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Wait_NotifyAllExample wait_notifyAllExample = new Wait_NotifyAllExample();

        ExecutorService ex = Executors.newCachedThreadPool();
        ex.execute(() -> wait_notifyAllExample.func2());
        ex.execute(() -> wait_notifyAllExample.func1());
    }
}
