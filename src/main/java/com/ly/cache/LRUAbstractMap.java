package com.ly.cache;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.hash;


/**
 * @Author: liyan
 * @Description: 1、实现一个LRU缓存，当缓存数据达到N之后淘汰掉最近最少使用的数据
 *                2、N小时之内没有被访问的数据也需要淘汰
 * @Date: Created in 20:20 2018/7/31
 * Function:
 *
 * 1.在做key生成hashcode使用的是HashMap的hash函数
 * 2.在做put  get时，为了方便没有使用
 */
public class LRUAbstractMap extends AbstractMap {
    private static final Logger LOGGER = LoggerFactory.getLogger(LRUAbstractMap.class);

    /**
     * 检查线程是否超期
     */
    private ExecutorService checkTimePool;

    /**
     * 设置map的最大的size
     */
    private final static int MAX_SIZE = 1024;

    private static final ArrayBlockingQueue<Node> QUEUE = new ArrayBlockingQueue<Node>(MAX_SIZE);

    /**
     *定义一个数组
     */
    private Object[] arrays;

    /**
     * 默认大小
     */
    private static final int DEFAULT_ARRAYS_SIZE = 1024;

    /**
     * 数组长度
     */
    private int arraysSize;

    /**
     * 判断是否停止flag，队列达到1024的时候，执行淘汰操作。true代表队列达到1024长度
     */
    private volatile boolean flag = true;

    /**
     * 超时时间：1h
     */
    private static final Long EXPIRE_TIME = 60 * 60 * 1000L;

    /**
     * 整个map的大小
     */
    private volatile AtomicInteger mapSize;

    public LRUAbstractMap() {
        arraysSize = DEFAULT_ARRAYS_SIZE;
        arrays = new Object[arraysSize];

        // 开启一个线程检查最先进入队列的值是否超期
        executeCheckTime();
    }

    /**
     * 开启一个线程检查最先进入队列的值是否超期，设置为守护线程
     */
    public void executeCheckTime() {

        // corePoolSize：核心线程数，默认情况下核心线程会一直存活，
        //               即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
        // maximumPoolSize：线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。
        //                  当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
        // keepAliveTime：非核心线程的闲置超时时间，超过这个时间就会被回收。
        // unit：指定keepAliveTime的单位，如TimeUnit.SECONDS。当将allowCoreThreadTimeOut设置为true时对corePoolSize生效
        // workQueue：线程池中的任务队列。常用的有三种队列：SynchronousQueue,LinkedBlockingDeque,ArrayBlockingQueue。
        // threadFactory：线程工厂，提供创建新线程的功能。ThreadFactory是一个接口，只有一个方法
        // RejectedExecutionHandler：RejectedExecutionHandler也是一个接口，只有一个方法
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("check_thread_%d").setDaemon(true).build();
        checkTimePool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        checkTimePool.execute(new CheckTimeThread());
    }

    @Override
    public Set<Entry> entrySet() {
        return super.keySet();
    }

    /**
     * 仿造HashMap写一个简单的put，get，remove，sizeUp(扩容)，sizeDown(缩容)等方法
     */
    @Override
    public Object put(Object k, Object v) {
        int hash = hash(k);
        int index = hash % arraysSize;
        Node node = (Node) arrays[index];
        if (node == null) {
            arrays[index] = new Node(null, null, k, v);
            QUEUE.offer((Node) arrays[index]);
            sizeUp();
        } else {
            Node node1 = node;
            Node node2 = node1;

            // 存在就覆盖
            if (node2.k == k) {
                node1.v = v;
            }
            while (node2.next != null){
                //key 存在 就覆盖 简单判断
                if (node2.k == k){
                    node2.v = v ;
                    break ;
                }else {
                    //不存在就新增链表
                    sizeUp();
                    Node node3 = new Node(node2,null,k,v) ;

                    //写入队列
                    QUEUE.offer(node) ;

                    node1.next = node ;
                }

                node2 = node2.next ;
            }
        }
        return null;
    }

    @Override
    public Object get(Object k) {
        int hash = hash(k) ;
        int index = hash % arraysSize ;
        Node currentNode = (Node) arrays[index] ;

        if (currentNode == null){
            return null ;
        }
        if (currentNode.next == null){

            //更新时间
            currentNode.setUpdateTime(System.currentTimeMillis());

            //没有冲突
            return currentNode ;

        }

        Node nNode = currentNode ;
        while (nNode.next != null){

            if (nNode.k == k){

                //更新时间
                currentNode.setUpdateTime(System.currentTimeMillis());

                return nNode ;
            }

            nNode = nNode.next ;
        }

        return super.get(k);
    }

    @Override
    public Object remove(Object k) {
        int hash = hash(k) ;
        int index = hash % arraysSize ;
        Node currentNode = (Node) arrays[index] ;

        if (currentNode == null){
            return null ;
        }

        if (currentNode.k == k){
            sizeDown();
            arrays[index] = null ;

            //移除队列
            QUEUE.poll();
            return currentNode ;
        }

        Node nNode = currentNode ;
        while (nNode.next != null){

            if (nNode.k == k){
                sizeDown();
                //在链表中找到了 把上一个节点的 next 指向当前节点的下一个节点
                nNode.pre.next = nNode.next ;
                nNode = null ;

                //移除队列
                QUEUE.poll();

                return nNode;
            }

            nNode = nNode.next ;
        }

        return super.remove(k);
    }

    @Override
    public  int size() {
        return mapSize.get();
    }

    /**
     * 增加size
     */
    public void sizeUp() {
        //在put值时候认为里边已经有数据了
        flag = true ;

        if (mapSize == null){
            mapSize = new AtomicInteger() ;
        }
        int size = this.mapSize.incrementAndGet();
        if (size >= MAX_SIZE) {
            //找到队列头的数据
            Node node = QUEUE.poll() ;
            if (node == null){
                throw new RuntimeException("data error") ;
            }

            //移除该 key
            Object key = node.k ;
            remove(key) ;
            lruCallback() ;
        }
    }

    /**
     * 数量减小
     */
    public void sizeDown() {
        if (QUEUE.size() == 0){
            flag = false ;
        }

        this.mapSize.decrementAndGet() ;
    }

    /**
     * copy HashMap 的 hash 实现
     * @param key
     * @return
     */
    public int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private void lruCallback(){
        LOGGER.debug("lruCallback");
    }

    /**
     * 链表
     */
    public class Node{
        private Node next;
        private Node pre;
        private Object k;
        private Object v;
        private Long updateTime;

        public Node(Node next, Node pre, Object k, Object v) {
            this.next = next;
            this.pre = pre;
            this.k = k;
            this.v = v;
            updateTime = System.currentTimeMillis();
        }

        public Long getUpdateTime(){
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + k + ",value=" + v + "}";
        }
    }

    public class CheckTimeThread implements Runnable {

        @Override
        public void run() {
            while (flag) {
                try {
                    Node node = QUEUE.poll(); // 从队列头部删除数据
                    if (node == null) {
                        continue;
                    }
                    Long time = node.getUpdateTime();
                    if ((time - System.currentTimeMillis()) >= EXPIRE_TIME) {
                        remove(node.k);
                    }
                } catch (Exception e) {
                    LOGGER.error("InterruptedException");
                }
            }
        }
    }
}
