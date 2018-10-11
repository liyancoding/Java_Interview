package com.ly.company_AC;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 20:23 2018/9/8
 * @Modified By:
 */
public class HaiKang_Test {
    public static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib1(int n) {
        int res[] = {1, 1};
        if (n <= 2) {
            return res[1];
        }
        int one = 1;
        int two = 1;
        int temp = 0;
        for (int j = 3; j <= n; j++) {
            temp = one + two;
            two = one;
            one = temp;
        }
        return temp;
    }
    
    public static void main(String[] args){
        System.out.println(fib(40));
        System.out.println(fib1(40));
    }
}
