package com.ly.company_AC;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description: 对于正整数n，找出0~n之间2出现的次数。比如输入n=3，那么输出1.
 * @Date: Created in 20:03 2018/9/17
 * @Modified By:
 */
public class QuTouTiao_Test2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(count1(n));
    }

    // 暴力解决
    public static int count(int n){
        int count = 0;
        while (n > 0) {
            // 先筛选出最右边的，如果最右边为2，那么除以10的余数一定为2
            if (n % 10 == 2) {
                count++;
            }
            // 向前进位，剔除最右边的数
            n = n / 10;
        }
        return count;
    }



    public static int count1(int n){
        int res = 0;
        for(int i=0; i<=n; ++i) {
            res += count(i);
        }
        return res;
    }
}
