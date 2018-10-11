package com.ly.leetcode.双指针;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * 题目描述：
 *          在有序数组中找出两个数，使它们的和为 target。
 * @Date: Created in 8:49 2018/8/21
 * @Modified By:
 */
public class TwoSumInputArrayIsSorted {
    public static int[] twoSum(int[] numbers, int target) {

        int[] index = new int[2]; // output

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                index[0] = left + 1;
                index[1] = right + 1;

                System.out.println("index1=" + index[0] + "," + "index2=" + index[1]);

                return index;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return null;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int numbers[] = new int[len];

        int target = sc.nextInt();

        for (int i=0;i<numbers.length;i++) {
            numbers[i] = sc.nextInt();
        }

        twoSum(numbers, target);

    }
}
