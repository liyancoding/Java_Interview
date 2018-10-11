package com.ly.offer;

import java.util.Arrays;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 9:44 2018/9/21
 * @Modified By:
 */
public class 连续子数组的最大和 {
    public static void main(String[] args){
        int[] ints = {-2,-8,-1,-5,-9};
        System.out.println(FindGreatestSumOfSubArray(ints));
    }

    /*
    暴力遍历
     */
    public static int FindGreatestSumOfSubArray(int[] array) {

        int sum = Arrays.stream(array).max().getAsInt();

        int temp;

        for (int i = 0; i < array.length; i++) {
            temp = array[i];
            for (int j = i + 1; j < array.length; j++) {
                temp = temp + array[j];
                if (temp > sum) {
                    sum = temp;
                }
            }
        }

        return sum;
    }

    /*
    动态规划
     */
    public int findGreatestSumOfSubArray(int[] array) {

        int MaxSum = Arrays.stream(array).max().getAsInt();;
        int ThisSum = 0;
        for (int anArray : array) {
            ThisSum += anArray;
            if (ThisSum > MaxSum)
                MaxSum = ThisSum;
        /*如果累加和出现小于0的情况，
           则和最大的子序列肯定不可能包含前面的元素，
           这时将累加和置0，从下个元素重新开始累加  */
            else if (ThisSum < 0)
                ThisSum = 0;
        }
        return MaxSum;
    }

}
