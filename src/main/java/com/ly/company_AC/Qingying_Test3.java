package com.ly.company_AC;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:23 2018/9/14
 * @Modified By:
 */
public class Qingying_Test3 {
    public static void main(String[] args){
        int temp = 0;
        int count = 0;
        int one, two, five, ten;
        for (ten=0;ten<=10;ten++) {
            for(five=0;five<=20;five++) {
                for (two=0;two<=50;two++) {
                    for (one=0;one<=100;one++) {
                        temp++; // 计算循环的次数
                        if (ten * 10 + five * 5 + two * 2 + one == 100) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println("循环的次数为：" + temp);
        System.out.println("组合的次数为：" + count);
    }
}
