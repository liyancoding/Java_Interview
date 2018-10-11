package com.ly.leetcode.双指针;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * 题目描述：
 *          判断一个数是否为两个数的平方和，例如 5 = 12 + 22。
 * @Date: Created in 9:28 2018/8/21
 * @Modified By:
 */
public class SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {

        int a=0;
        int b = (int) Math.sqrt(c);
        System.out.println("b= " + b);

        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) {
                System.out.println("It is true!");
                return true;
            } else if (sum < c) {
                a++;
            } else b--;
        }

        System.out.println("It is false!");
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        judgeSquareSum(c);
    }
}
