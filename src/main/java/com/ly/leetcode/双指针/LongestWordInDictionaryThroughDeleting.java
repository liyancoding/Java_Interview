package com.ly.leetcode.双指针;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * 题目描述：
 *         删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。
 *         如果有多个相同长度的结果，返回字典序的最小字符串。
 * @Date: Created in 20:22 2018/8/21
 * @Modified By:
 */
public class LongestWordInDictionaryThroughDeleting {

    public static String findLongestWord(String s, List<String> d) {

        String longestWord = "";

        for (String target : d) {
            int l1 = longestWord.length();
            int l2 = target.length();

            // 做返回用的
            // compareTo()就是比较两个值，如果前者大于后者，返回1，等于返回0，小于返回 < 0。
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }

            if (isValid(s, target)) {
                longestWord = target;
            }

        }

        return longestWord;
    }

    public static boolean isValid(String s, String target) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == target.length();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        List<String> list = new LinkedList<>();

        System.out.println("输入字典长度len: ");
        int len = sc.nextInt();

        System.out.println("输入字典list: ");
        for (int i=0;i<len;i++) {
            list.add(sc.next());
        }

        System.out.println("输入字符串s: ");
        String s = sc.next();



        String longestWord = findLongestWord(s, list);

        System.out.println("longestWord: " + longestWord);
    }
}
