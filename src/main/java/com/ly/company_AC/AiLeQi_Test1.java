package com.ly.company_AC;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 20:38 2018/9/8
 * @Modified By:
 */
public class AiLeQi_Test1 {
    public static void main(String[] args) {
//        int[] ints1 = {2, 7, 11, 15};
//        int[] ints2 = {1, 10, 4, 11};

//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        int[] ints1 = new int[n];
//        int[] ints2 = new int[n];
//
//        for (int i=0;i<n;i++) {
//            ints1[i] = scanner.nextInt();
//
//        }
//        for (int i=0;i<n;i++) {
//            ints2[i] = scanner.nextInt();
//
//        }
//
//        System.out.println(advantage(ints1,ints2));

        int[] ints1 = {12, 24, 8, 32};
        int[] ints2 = {13, 25, 32, 11};
        enhance(ints1, ints2);
//        System.out.println(enhance(ints1,ints2));

    }

    public static int advantage(int[] A, int[] B) {
        int result = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i] > B[i]) {
                result++;
            }
        }
        return result;
    }

    public static int enhance(int[] A, int[] B) {
        int result = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        List list = Arrays.asList(A);
        ArrayList<Integer> arrayList = new ArrayList<>(list);

        List list1 = Arrays.asList(B);
        ArrayList<Integer> arrayList1 = new ArrayList<>(list1);

        for (int i = 0;i<arrayList.size();i++) {
            for (int j = arrayList1.size()-1;j>=0;j--) {
                System.out.println(arrayList.get(i));
//                if (arrayList.get(i) >  arrayList1.get(j)) {
//                    result++;
//                    arrayList1.remove(j);
//                }
            }
        }
        return result;
    }
}
