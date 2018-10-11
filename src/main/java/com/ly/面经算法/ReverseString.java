package com.ly.面经算法;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description: 反转字符串和反转字符串中的句子
 * @Date: Created in 13:54 2018/9/7
 * @Modified By:
 */
public class ReverseString {

    /**
     * 反转字符串：利用逆序遍历遍历字符串 ABC ==》 CBA
     * @param string
     * @return
     */
    public static String reverseString(String string) {
        int len = string.length();
        StringBuffer stringBuffer = new StringBuffer();

        if (len == 0||string==null) {
            return string;
        }

        for (int i= len-1;i>=0;i--) {
            stringBuffer.append(string.charAt(i));
        }
        return stringBuffer.toString();
    }

    /**
     * 反转字符串中的句子：利用逆序遍历遍历字符串 ABC DEF ==》 DEF ABC
     * @param string
     * @return
     */
    public static String reverseStringOfSentense(String string) {
        String[] strings = string.split(" ");
        StringBuffer stringBuffer = new StringBuffer();

        if (string.length() == 0 || string == null) {
            return string;
        }

        for (int i=strings.length-1;i>=0;i--) {
            stringBuffer.append(strings[i]+ " ");
        }

        return stringBuffer.toString();
    }
    
    public static void main(String[] args){

        String str = "ABC DEF gbk";

//        System.out.println(reverseString(str));

        System.out.println(reverseStringOfSentense(str));
    }
}
