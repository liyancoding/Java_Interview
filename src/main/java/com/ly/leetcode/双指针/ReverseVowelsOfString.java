package com.ly.leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * 题目描述：
 *          反转一个字符串中的元音字符“a，e，i，o，u\\A，E，I，O，U”
 * @Date: Created in 9:54 2018/8/21
 * @Modified By:
 */
public class ReverseVowelsOfString {

    private final static ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a','e','i','o','u',
            'A','E','I','O','U'));

    public static String reverseVowels(String s) {

        int left = 0;
        int right = s.length() - 1;

        char[] chars = new char[s.length()];

        while (left <= right) {

            char left_Element = s.charAt(left);
            char right_Element = s.charAt(right);

            if (!vowels.contains(left_Element)) {
                chars[left++] = left_Element;
            } else if (!vowels.contains(right_Element)) {
                chars[right--] = right_Element;
            } else { // 都符合的话就做交换处理
                chars[left++] = right_Element;
                chars[right--] = left_Element;
            }
        }

        System.out.println("反转前：" + s + "\t" + "反转后：" + new String (chars));
        return chars.toString();
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

//        String s = "hello";

        reverseVowels(s);
    }
}
