package com.ly.newFeature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: liyan
 * @Description: 构造流的几种方法
 * @Date: Created in 13:51 2018/9/18
 * @Modified By:
 */
public class StreamConstruct {
    public static void main(String[] args){
        // 1. Individual values 单独值
        Stream stream = Stream.of("aa", "bb", "cc", "dd").map(a->a.toUpperCase());
        stream.forEach(System.out::println);

        // 2. Arrays 数组
        String[] strings = new String[]{"AA", "BB", "CC", "DD"};
//        stream = Stream.of(strings);
        stream = Arrays.stream(strings);
        System.out.println(stream.collect(Collectors.joining(";;")).toString());

        // 3. Collections 集合
        List<String> list = Arrays.asList("liyan", "zhouqian", "zzzzzz");
        list.stream()
                .filter(a -> a.length() > 4)
                .sorted((x, y) -> (y.length() - x.length())) // 按照字符串的长度降序排序的
//                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }
}
