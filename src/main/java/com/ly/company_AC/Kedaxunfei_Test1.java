package com.ly.company_AC;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 16:44 2018/9/7
 * @Modified By:
 */
public class Kedaxunfei_Test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T > 0) {
            int n = scanner.nextInt();
            int X = scanner.nextInt();

            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arrayList.add(scanner.nextInt());
            }

            Collections.sort(arrayList);

            int sum = 0;
            for (int num : arrayList) {
                sum += num;
            }

            int result = 0;
            int index = 0;
            while (sum / n < X) {
                result++;
                sum += (100 - arrayList.get(index));
                index++;
            }
            System.out.println(result);
            T--;
        }

    }
}
