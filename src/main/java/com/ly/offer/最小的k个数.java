package com.ly.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 20:48 2018/9/20
 * @Modified By:
 */
public class 最小的k个数 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || k > input.length) {
            return arrayList;
        }

        int[] ints = Arrays.stream(input).sorted()
                .limit(k)
//                .peek(System.out::println)
                .toArray();

        for (int i = 0; i < k; i++) {
            arrayList.add(ints[i]);
        }
        return arrayList;
    }

    public static void main(String[] args){
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }
}
