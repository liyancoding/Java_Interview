package com.ly.company_AC;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 19:36 2018/9/17
 * @Modified By:
 */
public class QuTouTiao_Test1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        StringBuffer stringBuffer = new StringBuffer();

        int len = s.length();

        for (int i=len-1;i>=0;i--) {
            stringBuffer.append(s.charAt(i));
        }
        return stringBuffer.toString();
    }

}
