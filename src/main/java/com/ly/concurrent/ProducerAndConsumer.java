package com.ly.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:46 2018/9/13
 * @Modified By:
 */
public class ProducerAndConsumer {
    // 生产者
    private static class Producer implements Runnable{
        private static BlockingQueue<String> queue_Pro;

        public Producer(BlockingQueue<String> queue_Pro) {
            this.queue_Pro = queue_Pro;
        }

        @Override
        public void run() {
            try {
                System.out.println("生产者放置产品：" + Thread.currentThread().getName());
                String producer = "生产者：" + Thread.currentThread().getName();
                queue_Pro.put(producer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 消费者
    private static class Consumer implements Runnable{
        private static BlockingQueue<String> queue_Con;

        public Consumer(BlockingQueue<String> queue_Con) {
            this.queue_Con = queue_Con;
        }
        @Override
        public void run() {
            try {
                String consumer = queue_Con.take();
                System.out.println(consumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(2);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        for (int i=0;i<5;i++) {
            new Thread(producer).start();
            new Thread(consumer).start();
        }

    }
}
