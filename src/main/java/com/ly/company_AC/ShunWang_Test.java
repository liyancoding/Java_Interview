package com.ly.company_AC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: LiYan
 * @Description: 删除数组中重复的元素
 * @Date: Created in 22:11 2018/10/9
 * @Modified By:
 */
public class ShunWang_Test {
    public static void main(String[] args){

//        int[] arr = {1, 2, 3, 4, 10, 8, 5, 1, 2};

        Scanner scanner = new Scanner(System.in);

        // 确定要输入数组的长度
        int len = scanner.nextInt();

        int[] arr = new int[len];

        // 手动输入元素
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        // 利用list接收元素，如果list中已经包含了数组中的元素，那么就不在重复添加
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }

        for (int ele : list) {
            System.out.print(ele + " ");
        }
    }
}
