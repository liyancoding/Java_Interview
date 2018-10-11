package com.ly.company_AC;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 16:20 2018/8/11
 * @Modified By:
 */
public class Wangyi_Test2 {

    public static void main(String[] args) {
//        int a=2;
//        int b=7;
//        int c=3;
//        int d=4;
//        int e=9;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // n=5
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();

        int m = scanner.nextInt();
        int input1 = scanner.nextInt();//输入
        int input2 = scanner.nextInt();
        int input3 = scanner.nextInt();


        ArrayList<Integer> apple_num=new ArrayList<>();

        apple_num.add(a);
        apple_num.add(b);
        apple_num.add(c);
        apple_num.add(d);
        apple_num.add(e);
        //System.out.println(apple_num.toString());
        ArrayList<Integer>apple= new ArrayList<>();
        //HashMap<Integer, Integer>apple=new HashMap<>();
        for (int i=0;i<apple_num.size();i++) {
            //System.out.println(apple_num.get(i));
            if(i==0) {
                apple.add( apple_num.get(i));
            }else {
                apple.add(apple_num.get(i)+apple.get(i-1));
            }

        }

        ArrayList<Integer> input =new ArrayList<>();
        input.add(input1);

        input.add(input2);
        input.add(input3);
        for (int k=0;k<input.size();k++) {

            for (int i=0;i<apple.size();i++) {
                if(input.get(k)<=apple.get(i)) {
                    System.out.print((i+1)+ " ");
                    break;
                }
            }
        }

    }

}
