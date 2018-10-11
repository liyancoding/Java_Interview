package com.ly.company_AC;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 16:02 2018/8/11
 * @Modified By:
 */
public class wangyi_Test3 {
    public static void main(String[] args){
        String s1 = "a";
        String s2 = "z";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for (int i=0;i<10;i++) {
            System.out.println(ints[i]);
        }
    }

}
