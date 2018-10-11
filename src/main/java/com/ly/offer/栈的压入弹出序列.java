package com.ly.offer;

import com.ly.javaIO.JavaIO_Demo;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 17:10 2018/9/20
 * @Modified By:
 */
public class 栈的压入弹出序列 {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }

        int len = pushA.length;

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int j = 0;

        stack.push(pushA[i++]);

        while (j < len) {
            // peek()函数返回栈顶的元素，但不弹出该栈顶元素。
            while (stack.peek() != popA[j]) {
                if (i == len) {
                    return false;
                }
                stack.push(pushA[i++]);
            }
            j++;
            // pop()函数返回栈顶的元素，并且将该栈顶元素出栈。
            stack.pop();
        }

        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();

        int[] pushA = new int[len];
        int[] popA = new int[len];

        for (int i = 0; i < len; i++) {
            pushA[i] = scanner.nextInt();
        }

        for (int i = 0; i < len; i++) {
            popA[i] = scanner.nextInt();
        }

        System.out.println(IsPopOrder(pushA,popA));
    }
}
