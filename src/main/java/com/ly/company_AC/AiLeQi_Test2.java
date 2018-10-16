package com.ly.company_AC;

import java.util.Arrays;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 20:39 2018/10/16
 * @Modified By:
 */
public class AiLeQi_Test2 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,4,3,2,45,3};
        int n=3;

        // System.out.println(Arrays.toString(nums));
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=n){
                nums[index]=nums[i];
                ++index;
            }
        }
        System.out.println(index);
        System.out.println(Arrays.toString(nums));
    }
}
