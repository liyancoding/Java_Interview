package com.ly.company_AC;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 18:46 2018/9/7
 * @Modified By:
 */
public class Kedaxunfei_Test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = sc.nextInt();

        for (int i=0;i<n;i++) {
            arrayList.add(sc.nextInt());
        }

        int result = 0;

        while (!isSafe(arrayList)) {
            result++;
            clean(arrayList);
        }

        System.out.println(result);


    }

    public static boolean isSafe(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size()-1; i++) {
            if (arrayList.get(i) > arrayList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void clean(ArrayList<Integer> arrayList) {
        for (int i=arrayList.size()-1;i>0;i--) {
            if (arrayList.get(i) < arrayList.get(i - 1)) {
                arrayList.remove(i);
            }
        }
    }
}
