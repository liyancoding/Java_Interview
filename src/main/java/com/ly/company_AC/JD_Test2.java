package com.ly.company_AC;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 19:37 2018/9/9
 * @Modified By:
 */
public class JD_Test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];

        for (int i = 0;i<n;i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int result = 0;
        for (int i = 0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (a[j] > a[i] && b[j] > b[i] && c[j] > c[i]) {
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);

    }
}
