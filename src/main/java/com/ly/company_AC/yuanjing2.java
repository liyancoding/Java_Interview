package com.ly.company_AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 10:40 2018/9/4
 * @Modified By:
 */
public class yuanjing2 {

    static int[] insource;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");

        insource = new int[n];
        result = new int[n];

        for (int i=0;i<n;i++) {
            int j = Integer.parseInt(str1[i]);
            insource[i] = j;
            j = Integer.parseInt(str2[i]);
            result[i] = j;
        }

        int i = 1;
        boolean isInsert = true;
        for (;i<n;i++) {
            if (result[i] < result[i - 1]) {
                break;
            }
        }

        for (int j=i;j<n;j++) {
            if (insource[j] != result[j]) {
                isInsert = false;
                break;
            }
        }

        if (isInsert) {
            System.out.println("Insert sort");
            InsertSort(i);
        }else {
            System.out.println("heap sort");
            heapsort(n);
        }

        for (i=0;i<n-1;i++) {
            System.out.println(result[i] + "");
        }
        System.out.println(result[n - 1]);
    }

    static void heapsort(int n) {
        int i = n - 1;
        for (;i>0;i--) {
            if (result[i] < result[0]) {
                break;
            }
        }
        exchanged(0, i);
        int temp = 0;
        while (temp < i) {
            int j = temp * 2 + 1;
            if (j >= i) {
                break;
            }
            if (result[j] < result[j + 1] && (j + 1) < i) {
                j++;
            }
            if (result[temp] < result[j]) {
                exchanged(temp, j);
                temp = j;
            } else {
                break;
            }
        }


    }

    static void InsertSort(int n) {
        for(int i =n;i>0;i--) {
            if (result[i] < result[i - 1]) {
                exchanged(i, i - 1);
            }else
                break;
        }
    }

    static void exchanged(int i, int j) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }
}
