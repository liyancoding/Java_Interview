package com.ly.company_AC;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:06 2018/9/9
 * @Modified By:
 */
public class ZiJieTiaoDong_Test1 {

    public static int maxUnique(String string) {
        if (string == null || string.equals("")) {
            return 0;
        }
        char[] chars = string.toCharArray();
        int[] map = new int[256];
        for (int i=0;i<256;i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for(int i=0;i!=chars.length;i++) {
            pre = Math.max(pre,map[chars[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chars[i]] = i;
        }
        return len;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(maxUnique(str));

    }
}
