package com.ly.leetcode.双指针;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * 题目描述：
 *         把归并结果存到第一个数组上。
 * @Date: Created in 15:56 2018/8/21
 * @Modified By:
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1 = m - 1;
        int index2 = n - 1;
        int mergeIndex = m + n - 1;

        while (index1>=0||index2>=0) {

            if (index1 < 0) {
                nums1[mergeIndex--] = nums2[index2--];

            } else if (index2 < 0) {
                nums1[mergeIndex--] = nums1[index1--];

            } else if (nums1[index1] > nums2[index2]) {
                nums1[mergeIndex--] = nums1[index1--];

            } else {
                nums1[mergeIndex--] = nums2[index2--];
            }
        }

    }
    
    public static void main(String[] args){
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};

        Scanner sc = new Scanner(System.in);
        System.out.println("m = ");
        int m = sc.nextInt();

        System.out.println("n = ");
        int n = sc.nextInt();

        int[] nums1 = new int[m+n];
        int[] nums2 = new int[n];

        for (int i=0;i<nums1.length;i++) {
            nums1[i] = sc.nextInt();
        }

        for (int i=0;i<nums2.length;i++) {
            nums2[i] = sc.nextInt();
        }

        merge(nums1,3,nums2,3);

        for (int i=0;i<nums1.length;i++) {
            System.out.print(nums1[i] + "\t");
        }
    }
}
