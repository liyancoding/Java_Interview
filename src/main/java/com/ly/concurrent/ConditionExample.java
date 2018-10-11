package com.ly.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 11:09 2018/8/11
 * @Modified By:
 */
public class ConditionExample {

    // 定义一个可重入锁
    Lock lock = new ReentrantLock();

    // 通过多次调用newCondition()方法绑定多个条件
    Condition condition = lock.newCondition();

    public void func1() {
        lock.lock();
        try {
            System.out.println("线程1先执行");
            condition.signal(); // condition.signalAll()
        }finally {
            lock.unlock();
        }
    }

    public void func2() {
        lock.lock();
        try {
            condition.await();
            System.out.println("线程2后执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args){

        ConditionExample conditionExample = new ConditionExample();

        ExecutorService ex = Executors.newCachedThreadPool();

        ex.execute(() -> conditionExample.func2());
        ex.execute(() -> conditionExample.func1());
    }
}
