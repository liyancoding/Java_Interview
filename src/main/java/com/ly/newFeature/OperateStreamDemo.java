package com.ly.newFeature;


import org.apache.hadoop.io.UTF8;
import sun.nio.cs.ext.GBK;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: LiYan
 * @Description: 流操作
 * @Date: Created in 14:12 2018/9/18
 * @Modified By:
 */
public class OperateStreamDemo {
    public static void main(String[] args){

        // 转换大写
        List<String> list = Arrays.asList("hello", "world", "i love you");
        List<String> list1 =
            list.stream().map(String::toUpperCase)
                    .map(s -> s.toLowerCase())
                    .map(s->{return s.toUpperCase();})
                    .collect(Collectors.toList());
        System.out.println(list1.toString());

        // 求平方根
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().map(i -> i * i)
                .collect(Collectors.toList())
                .forEach(i->System.out.print(i + " "));

        // 留下偶数
        System.out.println();
        int[] ints = {1, 23, 4, 5, 68, 126, 432, 1564, 321, 564, 46};
        Arrays.stream(ints).filter(i -> i % 2 == 0)
                .forEach(i -> System.out.print(i + " "));

        // peek操作
        System.out.println();
        Stream.of("one", "two", "three", "four")
                .filter(i -> i.length() > 3)
                .peek(i -> System.out.println("对每一个元素都进行操作：" + i))
                .map(String::toUpperCase)
                .peek(i -> System.out.println("Mapped Value:" + i))
                .collect(Collectors.toList());
//                .forEach(i -> System.out.print(i + " "));

        // reduce用例
        System.out.println();
        int[] ints1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = Arrays.stream(ints1).reduce(100, (a, b) -> a + b);
        System.out.println("sum = " + sum); // 145

        int sum1 = Arrays.stream(ints1).reduce(0, Integer::sum);
        System.out.println("sum1 = " + sum1); // 45

        int sum2 = Arrays.stream(ints1).reduce(Integer::sum).getAsInt();
        System.out.println("sum2 = " + sum2); //45

        String s =
        Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0)
                .reduce("", String::concat);
        System.out.println(s);

        // limit/skip (limit 返回Stream的前面n个元素; skip 则是扔掉前n个元素; 它是由一个叫subStream的方法改名而来.)
        List<Integer> list2 = new ArrayList<>();
        for (int i=0;i<20;i++) {
            list2.add(i);
        }
        list2.stream().limit(15)
                .skip(10)
                .forEach(i->System.out.print(i + " "));

        // 生成一个等差数列
        System.out.println();
        Stream.iterate(100,i -> i + 5)
                .limit(10)
                .skip(5)
                .forEach(i->System.out.print(i + " "));

        System.out.println();

        // 利用System.getProperty()函数获取当前路径
        Path path = Paths.get(System.getProperty("user.dir")
                + "/src/main/java/com/ly/newFeature/OperateStreamDemo.java"); // user.dir指定了当前的路径

//        Path path = Paths.get("E:\\Java_Interview\\test\\src.txt");

        // 1. Java 8 Read File + Stream
        System.out.println("开始");
        try{
            Stream<String> stringStream = Files.lines(path);
//            List<String> output = stringStream.flatMap(line -> Stream.of(line.split(" ")))
//                    .filter(word -> word.length() > 0)
//                    .collect(Collectors.toList());
//            System.out.println(output);
            stringStream.flatMap(line->Stream.of(line.replace(" ",",").split(",")))
                    .filter(word->word.length()>0)
//                    .collect(Collectors.toList())
                    .forEach(i->System.out.println(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("结束");

        System.out.println();

        System.out.println("开始");

        // 2. BufferedReader + Stream
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            bufferedReader.lines().flatMap(line->Stream.of(line.replace(" ",",").split(",")))
                    .filter(word->word.length()>0)
                    .forEach(i->System.out.println(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
