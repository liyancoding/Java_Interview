package com.ly.八大排序;

/**
 * @Author: liyan
 * @Description: 冒泡排序
 * @Date: Created in 13:25 2018/8/22
 * @Modified By:
 */
public class MaoPao {

    public static void maopao(int[] arr) {

        for (int i=0;i<arr.length-1;i++) { // 控制冒泡排序的趟数
            for (int j=0;j<arr.length-1-i;j++) { // 控制每一趟需要进行的次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
    
    public static void main(String[] args){
        int[] arr = {38,65,97,76,13,27,10};
        maopao(arr);

        System.out.println("排序后的结果：");

        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }
}
