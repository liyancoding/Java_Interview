package com.ly.leetcode.排序;

import com.sun.corba.se.impl.naming.cosnaming.InternalBindingKey;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: liyan
 * @Description: 实现小根堆：时间复杂度 O(NlogK)，空间复杂度 O(K)。
 * 题目描述:
 *          找到无序数组中第k个最大的值
 * @Date: Created in 9:18 2018/8/23
 * @Modified By:
 */
public class FindKthLargest {

    // 用数组实现
    public static int findKthLargest_Array(int[] num, int k) {
        Arrays.sort(num);
        int arr[] = new int[num.length];
        for (int i=num.length-1;i>=0;i--) {
            arr[i] = num[i];
        }
        return arr[arr.length - k];
    }

    public static int findKthLargest(int[] num, int k) {

        // 默认实现小根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val : num) {
            priorityQueue.add(val);
//            System.out.println(priorityQueue);
            if (priorityQueue.size() > k) {
                priorityQueue.poll(); // 删除
            }
        }

        return priorityQueue.peek();
    }
    
    public static void main(String[] args){
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = findKthLargest(arr, 5);

        int k_Array = findKthLargest_Array(arr, 5);

        System.out.println("k= " + k + " k_Array= " + k_Array);
    }
}
