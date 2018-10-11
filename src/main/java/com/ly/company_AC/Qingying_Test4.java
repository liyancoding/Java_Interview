package com.ly.company_AC;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 9:43 2018/9/14
 * @Modified By:
 */
public class Qingying_Test4 {
    public static void main(String[] args) {

        int[] a = {1, 2, 9, 5, 0};
        int[] b = {9, 3, 3, 9, 5};

        method(a, b);
    }

    /**
     * 有两个数组a,b,大小都为n,数组元素的值任意,无序;要求:通过交换a,b中的元素,使数组a元素的和与数组b元素的和之间的差最小</br>
     * 思路
     * 1.算a b 之间的差值 differ</br>
     * 2. 找出 a b 数组中差值最接近differ/2 的元素</br>
     * 3. 交换元素</br>
     *
     * 在步骤２中，为什么是最接近differ/2 的元素，而不是differ</br>
     * 因为： d' = sum(a) - a[i] + b[j] - (sum(b) - b[j] = a[i])</br>
     * 			= sum(a) - sum(b) -2(a[i] - b[j])</br>
     * 			= differ - 2(a[i] - b[j]) </br>
     * 要想两数组的差值最小，那么d' 就得最接近0（等于0最好了），那么differ 就与a[i]-b[j]存在2倍的关系。
     *
     *  @param  a
     *  @param  b
     *
     */
    public static void method(int[] a,int[] b) {

        int n = a.length;

        // 求两个数组的差值
        int differ = 0;
        for (int i = 0; i < n; i++) {
            differ += a[i] - b[i];
        }
        System.out.println();
        System.out.println("\n数组a 与数组b 的差值 ： " + differ);
        if (differ == 0) { // 没有差值 两数组相等，结束！
            System.out.println("数组a 和数组b 相等， 没有差值！");
        } else { // 在数组a 和b 中找出两个数　让他们的差最接近　difference/2
            int tmp = 0; // a[i] 与 b[j] 的差值
            double zjj = 1000; // differ/2 与tmp 的差值
            int exchangea = -1; // 数组a的下标
            int exchangeb = -1; // 数组b的下标
            boolean finish = false; // 如果交换后差值等于difference/2 退出循环
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tmp = a[i] - b[j];
                    if (tmp == differ / 2) {
                        exchangea = i;
                        exchangeb = j;
                        finish = true;
                        break;
                    } else { // 不相等 找出差值最接近differ/2 的两个数
                        double aa = differ / 2 - tmp;
                        if (Math.abs(aa) < Math.abs(zjj)) {
                            zjj = aa;
                            exchangea = i;
                            exchangeb = j;
                        }
                    }
                }
                if (finish) {
                    break;
                }
            }

            if (exchangea != -1 && exchangeb != -1) {
                System.out.println("交换 a[" + exchangea + "]  " + a[exchangea]
                        + " 和 b[" + exchangeb + "]  " + b[exchangeb]);
            }
            // 交换
            a[exchangea] = a[exchangea] + b[exchangeb];
            b[exchangeb] = a[exchangea] - b[exchangeb];
            a[exchangea] = a[exchangea] - b[exchangeb];

            // 交换后的差值
            differ = 0;
            for (int i = 0; i < n; i++) {
                differ += a[i] - b[i];
            }
            System.out.println("交换后的差值 ： " + differ);

        }
    }
}