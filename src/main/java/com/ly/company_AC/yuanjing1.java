package com.ly.company_AC;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:26 2018/9/4
 * @Modified By:
 */
public class yuanjing1 {
    public static boolean canJump(int[] A) {
        int length = 0;

        for (int i=0;i<A.length&&i<=length;i++) {
            length = Math.max(i + A[i], length);
        }

        if (length >= A.length - 1) {
            return true;
        }else
            return false;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int[] ints = new int[len];

        for (int i = 0;i<ints.length;i++) {
            ints[i] = sc.nextInt();
        }

        boolean b = canJump(ints);

        System.out.println(b);


//        int[] i = {2, 3, 1, 1, 4};
//
//        boolean b = canJump(i);
//        System.out.println(b);
//
//        int[] ints = {3, 2, 1, 0, 4};
//        boolean b1 = canJump(ints);
//        System.out.println(b1);
    }
}
