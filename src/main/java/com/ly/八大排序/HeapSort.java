package com.ly.八大排序;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description: 大根堆和小根堆
 *      利用优先队列PriorityQueue实现。阿里一面
 * @Date: Created in 10:53 2018/8/23
 * @Modified By:
 */
public class HeapSort {

    // 小根堆
    public static String smallHeap(int[] arr) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int val : arr) {
            priorityQueue.add(val);
        }

        return priorityQueue.toString();
    }

    // 大根堆
    public static String bigHeap(int[] arr) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int val : arr) {
            priorityQueue.add(val);
        }

        return priorityQueue.toString();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("输入数组长度：");
        int len = sc.nextInt();

        int[] arr = new int[len];
        for (int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }

        String smallHeap = smallHeap(arr);
        String bigHeap = bigHeap(arr);

        System.out.println("smallHeap: " + smallHeap + "\n" + "bigHeap: " + bigHeap);

    }
}
