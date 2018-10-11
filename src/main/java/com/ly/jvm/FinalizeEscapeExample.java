package com.ly.jvm;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 15:09 2018/8/15
 * @Modified By:
 */
public class FinalizeEscapeExample {
    private static FinalizeEscapeExample finalizeEscapeExample = null;

    public void isAlive() {
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("执行finalize()方法");
        FinalizeEscapeExample.finalizeEscapeExample = this;
    }

    public static void main(String[] args) throws InterruptedException {
        finalizeEscapeExample = new FinalizeEscapeExample();

        // 对象第一次成功的拯救了自己
        finalizeEscapeExample = null; // 表明为不可达的对象

        System.gc(); // 进行回收，会调用finalize()方法进行自救，并且自救成功

        // 由于finalize()优先级很低，所以暂停0.5s等待它
        Thread.sleep(500);

        if (finalizeEscapeExample != null) {
            finalizeEscapeExample.isAlive();
        } else {
            System.out.println("对象已死");
        }

        // 自救失败
        finalizeEscapeExample = null;
        System.gc();
        Thread.sleep(500);
        if (finalizeEscapeExample != null) {
            finalizeEscapeExample.isAlive();
        } else {
            System.out.println("对象已死");
        }
    }
}
