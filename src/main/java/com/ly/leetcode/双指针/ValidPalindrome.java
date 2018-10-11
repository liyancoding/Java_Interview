package com.ly.leetcode.双指针;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * 题目描述：
 *          可以删除一个字符，判断是否能构成回文字符串。
 * @Date: Created in 14:28 2018/8/21
 * @Modified By:
 */
public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        int start = -1;
        int end = s.length();

        while (start < end) {
            if (s.charAt(++start) != s.charAt(--end)) {
                return validPalindrome(s, start, end - 1) || validPalindrome(s, start + 1, end);
            }
        }

        System.out.println("It is true!");
        return true;
    }

    public static boolean validPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                System.out.println("It is false!");
                return false;
            }
        }
        System.out.println("It is true!");
        return true;
    }
    
    public static void main(String[] args){
//        String s = "abc";

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        validPalindrome(s);
    }
}
