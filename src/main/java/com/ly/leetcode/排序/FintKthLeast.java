package com.ly.leetcode.排序;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: liyan
 * @Description: 实现大根堆
 * @Date: Created in 9:44 2018/8/23
 * @Modified By:
 */
public class FintKthLeast {

    public static int findKthLeast(int[] num,int k) {

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2; // 实现小根堆
//                return o2 - o1; // 实现大根堆
//            }
//        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2); // 实现小根堆
                return o2.compareTo(o1); // 实现大根堆
            }
        });

        for (int val : num) {
            priorityQueue.add(val);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }
    
    public static void main(String[] args){
        int[] arr = {4, 3, 8,13, 5, 9,15,12};

        int k = findKthLeast(arr,5);

        System.out.println("k= " + k);
    }
}
