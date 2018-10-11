package com.ly.newFeature;

import org.w3c.dom.ls.LSInput;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:30 2018/9/18
 * @Modified By:
 */
public class StreamDemo {
    public static void main(String[] args){
        List<String> list = Arrays.asList("regular", "expression", "specified", "as", "a", "string", "must");

        int count = 0;
        for (String str : list) {
            if (str.length() > 7) {
                count++;
            }
        }
        System.out.println("count = " + count);

        /**
         * lambda表达式
         */
        long res = list.stream().sorted().filter(a -> a.length() > 7).count(); // 排序，求出list中字符串长度大于7的个数
        System.out.println("res = " + res);
        list.stream().sorted().filter(a -> a.length() > 7).forEach(System.out::println);
        list.parallelStream().sorted().filter(a -> a.length() > 7).forEach(System.out::println);
//        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); // 逆序

        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Arrays.stream(ints).filter(a -> a % 2 == 1).forEach(System.out::println);
        Arrays.stream(ints).filter(a -> a % 2 == 0).forEach(System.out::println);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aa");
        map.put(2, "bb");
        map.put(3, "cc");
        map.put(4, "dd");


    }
}
