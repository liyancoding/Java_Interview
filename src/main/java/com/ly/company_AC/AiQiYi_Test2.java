package com.ly.company_AC;

import java.util.Scanner;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 19:10 2018/9/28
 * @Modified By:
 */
public class AiQiYi_Test2 {
    public static void main(String[] args){

//        int[] arr = {1,2,3};
//        System.out.println(num(arr));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(num(arr) + 1);

    }

    public static int num(int[] arr) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : arr) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
