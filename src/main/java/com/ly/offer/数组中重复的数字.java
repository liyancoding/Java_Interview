package com.ly.offer;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 18:06 2018/9/20
 * @Modified By:
 */
public class 数组中重复的数字 {
    public static void main(String[] args) {

        int[] ints = {1,2,3,4,5,5};
        int[] ints1 = new int[ints.length];

        System.out.println(duplicate(ints, 6, ints1));

    }


    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++){
            sb.append(numbers[i] + "");
        }
        for(int j = 0; j < length; j++){
            if(sb.indexOf(numbers[j]+"") != sb.lastIndexOf(numbers[j]+"")){
                duplication[0] = numbers[j];
                return true;
            }
        }
        return false;
    }
}
