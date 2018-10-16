package com.ly.company_AC;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 17:43 2018/10/16
 * @Modified By:
 */
public class AiLeQi_Test3 {
    public static int result=0;
    public static int M=2;
    public static int N=2;

    public static void f(int[][] nums,int x,int y){
        if(x==M-1 && y==N-1){
            result++;
            return;
        }

        // 向右
        if(y+1<N){
            f(nums,x,y+1);
        }

        // 向下
        if(x+1<M){
            f(nums,x+1,y);
        }
    }

    public static void main(String[] args) {
        int[][] nums=new int[M][];
        for (int i = 0; i < M; i++) {
            nums[i]=new int[N];
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }

        f(nums,0,0);
        System.out.println(result);
    }
}
