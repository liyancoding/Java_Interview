package com.ly.八大排序;

import org.apache.tools.ant.taskdefs.optional.jsp.WLJspc;

/**
 * @Author: liyan
 * @Description: 快速排序
 * @Date: Created in 8:51 2018/8/22
 * @Modified By:
 */
public class FastSort {

    /**
     * 选取基准值，进行第一趟排序，返回第一趟排序后基准值所处的位置！！
     * 其中，基准值左边都小于基准值，基准值右边都大于基准值
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] arr, int low, int high) {

        // 选择第一个元素作为基准值
//        int base = arr[low];
//
//        while (low < high) {
//            while (arr[high] >= base && low < high) {
//                high--;
//            }
//            if (low < high) {
//                int temp = arr[high];
//                arr[high] = arr[low];
//                arr[low] = temp;
//                low++;
//            }
//
//            //上面的while循环结束时，就说明当前的a[high]的值比基准值小，应与基准值进行交换
//            while (arr[low] <= base && low < high) {
//                low++;
//            }
//
//            //上面的while循环结束时，就说明当前的arr[low]的值比基准值大，应与基准值进行交换
//            if (low < high) {
//                int temp = arr[high];
//                arr[high] = arr[low];
//                arr[low] = temp;
//                high--;
//            }
//        }
//        return high;

        // 选择最后一个元素作为基准
        int base = arr[high];
        while (low < high) {
            while (base >= arr[low] && low < high) {
                low++;
            }

            if (low < high) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
                high--;
            }

            while (base <= arr[high] && low < high) {
                high--;
            }

            if (low < high) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
                low++;
            }
        }

        return low;
    }

    /**
     * 左右两部分分别递归实现
     * @param arr
     * @param low
     * @param high
     */
    public static void left_right_Recursion(int[] arr, int low, int high) {
        if (low > high) {
            return;
        } else {
            int partition = partition(arr, low, high);

            // 递归
            left_right_Recursion(arr, low, partition - 1);
            left_right_Recursion(arr, partition + 1, high);
        }
    }
    
    public static void main(String[] args){
        int[] a = new int[]{2, 7, 4, 5, 10, 1, 9, 3, 8, 6};

        int[] b = {34, 3, 53, 2, 23, 7, 14, 10};

        left_right_Recursion(a, 0, a.length - 1);

        left_right_Recursion(b, 0, b.length - 1);

        System.out.println("排序后的结果：");

        for (int arr : a) {
            System.out.print(arr + "\t");
        }

        System.out.println();

        for (int arr : b) {
            System.out.print(arr + "\t");
        }
    }
}
