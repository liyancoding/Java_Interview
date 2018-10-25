package com.ly.company_AC;
import java.util.Scanner;
/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 16:42 2018/10/22
 * @Modified By:
 */
public class ZOOM_Test {

    /**
     * 有N个人围成一圈，顺序排号。 从第一个人开始报数（从1到3报数）， 凡报到3的人退出圈子，问最后留下的和最后走出圈的孩纸？
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
//        System.out.print("请输入排成一圈的人数：");
        int n = s.nextInt();
        boolean[] arr = new boolean[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        } // 数组赋值都是true

        int leftCount = n;
        int countNum = 0;
        int index = 0;
        while (leftCount > 1) {
            if (arr[index] == true) {
                countNum++;
                if (countNum == 3) {
                    countNum = 0;
                    arr[index] = false;
                    leftCount--;
                }
            }
            index++;
            if (index == n) {
                index = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == true) {
//                System.out.println("原排在第" + (i + 1) + "位的人留下了。");
                System.out.println(i + 1);
            }
        }
    }
}

