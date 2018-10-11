package com.ly.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 12:36 2018/9/25
 * @Modified By:
 */
public class HeapOutOfMemoryError {
    public static void main(String[] args){
        List<HeapOutOfMemoryError> list = new ArrayList<>();

        while (true) {
            System.out.println(list.add(new HeapOutOfMemoryError()));
        }

    }
}
