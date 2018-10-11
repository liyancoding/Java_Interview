package com.ly.offer;

import com.ly.concurrent.ForkJoinExample;

import java.util.Arrays;



/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 21:23 2018/9/20
 * @Modified By:
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    // 桶排序的过程
    public static int MoreThanHalfNum_Solution(int [] array) {

        int maxNum = Arrays.stream(array)
                .max().getAsInt();

        int targetNum = 0;
        int half = array.length / 2;
        int[] bucket = new int[maxNum + 1];

        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }


        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > half) {
                targetNum = i;
            }
        }

        return targetNum;
    }
}
