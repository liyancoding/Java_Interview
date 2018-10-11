package com.ly.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 15:20 2018/8/13
 * @Modified By:
 */
public class ForkJoinExample extends RecursiveTask<Integer>{

    private int left;
    private int right;

    ForkJoinExample(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer compute() {
        int res = 0;
        if (right - left <= 100) {
            // 任务足够小就直接计算
            for (int i = left; i < right; i++) {
                res += i;
            }
        } else {
            // 用二分法拆分成小的任务并行计算
            int middle = left + (left + right) / 2;
            // 左边子任务
            ForkJoinExample leftTask = new ForkJoinExample(left, middle);
            // 右边子任务
            ForkJoinExample rightTask = new ForkJoinExample(middle + 1, right);

            leftTask.fork();
            rightTask.fork();

            res = leftTask.join() + rightTask.join();
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinExample fo = new ForkJoinExample(1, 1000);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Future future = forkJoinPool.submit(fo);

        System.out.println(future.get());
    }
}
