package com.ly.company_AC;

import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 20:04 2018/9/18
 * @Modified By:
 */
public class DiDi_Test2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int np,nq,nr;
        np = scanner.nextInt();
        nq = scanner.nextInt();
        nr = scanner.nextInt();
        Integer[] P = new Integer[np];
        Integer[] Q = new Integer[nq];
        Integer[] R = new Integer[nr];
        int res = 0;
        List<Integer[]> list1 = new ArrayList<>();
        list1.add(P);
        list1.add(Q);
        list1.add(R);


        System.out.println(doExchange(list1));

    }

    public static int doExchange(List<Integer[]> arrayLists){
        int res = 0;

        int len=arrayLists.size();
        //拿到第一个数组
        int len0;
        if (arrayLists.get(0) instanceof Integer[]){
            Integer[] arr0=  arrayLists.get(0);
            len0=arr0.length;
        }else {
            len0 = arrayLists.get(0).length;
//            len0=((ArrayList<Integer[]>)arrayLists.get(0)).size();
        }

        //拿到第二个数组
        Integer[] arr1=  arrayLists.get(1);
        int len1=arr1.length;

        //计算当前两个数组一共能够组成多少个组合
        int lenBoth=len0*len1;

        //定义临时存放排列数据的集合
        ArrayList<ArrayList<Integer>> tempArrayLists=new ArrayList<>(lenBoth);

        //第一层for就是循环arrayLists第一个元素的
        for (int i=0;i<len0;i++){
            //第二层for就是循环arrayLists第二个元素的
            for (int j=0;j<len1;j++){
                //判断第一个元素如果是数组说明，循环才刚开始
                if (arrayLists.get(0) instanceof Integer[]){
                    Integer[] arr0= arrayLists.get(0);
                    ArrayList<Integer> arr=new ArrayList<>();
                    arr.add(arr0[i]);
                    arr.add(arr1[j]);
                    //把排列数据加到临时的集合中
                    tempArrayLists.add(arr);
                }else {
                    //到这里就明循环了最少一轮啦，我们把上一轮的结果拿出来继续跟arrayLists的下一个元素排列
                    Integer[] arrtemp= arrayLists.get(0);
                    ArrayList<Integer> arr=new ArrayList<>();
                    for (int k=0;k<arrtemp[i];k++){
                        arr.add(arrtemp[k]);
                    }
                    arr.add(arr1[j]);
                    tempArrayLists.add(arr);
                    res++;
                }
            }
        }

        //这是根据上面排列的结果重新生成的一个集合
        List newArrayLists=new ArrayList<>();
        //把还没排列的数组装进来，看清楚i=2的喔，因为前面两个数组已经完事了，不需要再加进来了
        for (int i=2;i<arrayLists.size();i++){
            newArrayLists.add(arrayLists.get(i));
        }
        //记得把我们辛苦排列的数据加到新集合的第一位喔，不然白忙了
        newArrayLists.add(0,tempArrayLists);

        //你没看错，我们这整个算法用到的就是递归的思想。
        doExchange(newArrayLists);
        return res;
    }
}
