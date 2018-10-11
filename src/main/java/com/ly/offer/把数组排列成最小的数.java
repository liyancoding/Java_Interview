package com.ly.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 13:21 2018/9/21
 * @Modified By:
 */
public class 把数组排列成最小的数 {
    public static void main(String[] args){
        int[] numbers = {3, 32, 321};
        System.out.println(PrintMinNumber(numbers));
    }

    /*
    运行时间：21ms
    占用内存：9692k
     */

    /*
     * 解题思路：
     * 排序规则如下：
     * 若ab > ba 则 a > b，
     * 若ab < ba 则 a < b，
     * 若ab = ba 则 a = b；
     * 解释说明：
     * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较
     */
    public static String PrintMinNumber(int[] numbers) {

        StringBuffer str = new StringBuffer();

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(numbers[i]);
        }

        /*
        所以在这里自定义一个比较大小的函数，比较两个字符串s1, s2大小的时候，先将它们拼接起来，
        比较s1+s2,和s2+s1那个大，如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。
         */
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;

                return s1.compareTo(s2);
            }
        });

        for (Integer integer : arrayList) {
            str.append(integer);
        }

        return str.toString();
    }
}
