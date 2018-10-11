package com.ly.basic.newfeature;

import java.util.function.Supplier;

/**
 * @Author: liyan
 * @Description: Java 8增加了两个新的概念在接口声明的时候：默认和静态方法。默认方法和Trait有些类似，但是目标不一样。
 * 默认方法允许我们在接口里添加新的方法，而不会破坏实现这个接口的已有类的兼容性，也就是说不会强迫实现接口的类实现默认方法。
 * 默认方法和抽象方法的区别是抽象方法必须要被实现，默认方法不是。
 * 作为替代方式，接口可以提供一个默认的方法实现，
 * 所有这个接口的实现类都会通过继承得倒这个方法（如果有需要也可以重写这个方法）。
 * @Date: Created in 15:13 2018/8/7
 * @Modified By:
 */
public interface DefaultMethodsInInterface {
    // 声明default的方法
    default String notRequired() {
        return "Default Methods";
    }

    // 声明static方法
    static DefaultMethodsInInterface create(Supplier<DefaultMethodsInInterface> supplier) {
        return supplier.get();
    }
}

class DefaultImpl implements DefaultMethodsInInterface{

}

class OverrideImpl implements DefaultMethodsInInterface {
    @Override
    public String notRequired() {
        return "Override implementation";
    }

    public static void main(String[] args){

        // ::new是构造方法的引用
        DefaultMethodsInInterface de = DefaultMethodsInInterface.create(DefaultImpl::new);
        System.out.println(de.notRequired());

        de = DefaultMethodsInInterface.create(OverrideImpl::new);
        System.out.println(de.notRequired());
    }
}


