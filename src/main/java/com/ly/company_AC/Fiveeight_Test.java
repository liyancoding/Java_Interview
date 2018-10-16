package com.ly.company_AC;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 20:53 2018/10/13
 * @Modified By:
 */
public class Fiveeight_Test {
    public static void main(String[] args){
        int[] i = {1, 2, 3, 5, 9};
        System.out.println(func(i,8));
    }

    public static int func(int[] arr, int n) {
        int temp = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] >= n) {
                temp = i;
            }
        }
        return temp;
    }
}
