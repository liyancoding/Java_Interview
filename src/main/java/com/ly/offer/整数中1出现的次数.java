package com.ly.offer;

import org.apache.hadoop.fs.shell.Count;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 10:37 2018/9/21
 * @Modified By:
 */
public class 整数中1出现的次数 {
    public static void main(String[] args){
        int n = 13;
        System.out.println("res = " + NumberOf1Between1AndN_Solution(n));
    }

    /**
     * 数字n中1出现的次数
     * @param n
     * @return
     */
    public static int someNum(int n) {

        int count = 0;

        while (n >= 1) {
            if (n % 10 == 1) {
                count++;
            }
            n = n / 10;
        }

        return count;
    }

    /**
     * 1~n中数字1出现的次数
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;

        /*
        运行时间：19ms
        占用内存：9148k
         */
        for (int i = 1; i <= n; i++) {
            res += someNum(i);
        }

        /*
        运行时间：312ms
        占用内存：23084k
         */
//        for (int i = 1; i <= n; i++) {
//            res += Stream.of(i)
//                    .mapToInt(a->someNum(a))
////                    .peek(System.out::println)
//                    .sum();
//        }

        return res;
    }
}
