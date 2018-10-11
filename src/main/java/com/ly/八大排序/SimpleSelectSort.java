package com.ly.八大排序;

/**
 * @Author: liyan
 * @Description: 简单选择排序
 * @Date: Created in 14:06 2018/8/22
 * @Modified By:
 */
public class SimpleSelectSort {

    public static void selectSort(int[] arr) {
        for (int i=0;i<arr.length-1;i++) { // 控制趟数
            for (int j=i+1;j<arr.length;j++) { // 遍历数组
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args){
        int[] arr = {6, 3, 8, 2, 9, 1};

        selectSort(arr);

        System.out.println("排序后的结果：");

        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }
}
