package com.ly.八大排序;

/**
 * @Author: liyan
 * @Description: 直接插入排序
 * @Date: Created in 14:44 2018/8/22
 * @Modified By:
 */
public class InsertSort {

    public static void insert(int[] arr) {
        for(int i=1;i<arr.length;i++) {
            for (int j=i;j>0&&arr[j]<arr[j-1];j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }
    
    public static void main(String[] args){
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6};

        insert(a);

        System.out.println("排序后的结果：");

        for (int arr : a) {
            System.out.print(arr + "\t");
        }
    }
}
