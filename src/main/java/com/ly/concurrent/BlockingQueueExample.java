package com.ly.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 14:42 2018/8/13
 * @Modified By:
 */
public class BlockingQueueExample {
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);

    // 生产者
    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": " + "生产者放置产品" );

                // 生产者往队列里面放产品，如果队列满，则阻塞。
                blockingQueue.put(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者
    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                // 消费者从队列里取产品，如果队列为空，则阻塞队列。
                Integer integer = blockingQueue.take();

                System.out.println(Thread.currentThread().getName() + ": " + "消费者消费产品：" + integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){

        // 创建5个Producer
        for (int i=0;i<5;i++) {
            Producer producer = new Producer();
            producer.start();
        }

        // 创建15个Consumer
        for (int i=0;i<15;i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for(int i=0;i<20;i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }
}
