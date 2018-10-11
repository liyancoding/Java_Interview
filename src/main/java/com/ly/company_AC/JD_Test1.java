package com.ly.company_AC;

import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 20:51 2018/9/9
 * @Modified By:
 */
public class JD_Test1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt();

        while(n > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            boolean nodes[][] = new boolean[N][N];
            while(M-- > 0) {
                int i = sc.nextInt() - 1;
                int j = sc.nextInt() - 1;
                nodes[i][j] = true;
                nodes[j][i] = true;
            }
            int result[] = new int[N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(nodes[i][j]) result[i]++;
                }
            }
            boolean flag = true;
            for(int i = 0; i < N; i++) {
                for(int j = i; j < N; j++) {
                    if(!nodes[i][j]) {
                        if(result[i] != result[j]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag) break;
            }
            if(!flag) {
                System.out.println("No");
            }
            else {
                System.out.println("Yes");
            }
            n--;
        }
    }

}
