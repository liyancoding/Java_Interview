package com.ly.basic.newfeature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Author: liyan
 * @Description: 方法引用提供了一个很有用的语义来直接访问类或者实例的已经存在的方法或者构造方法。
 * 结合Lambda表达式，方法引用使语法结构紧凑简明。不需要复杂的引用。
 * @Date: Created in 15:28 2018/8/7
 * @Modified By:
 */
public class MethodReference {
    public static MethodReference create(final Supplier<MethodReference> supplier) {
        return supplier.get();
    }

    public static void collide(final MethodReference methodReference) {
        System.out.println("Collide " + methodReference.toString());
    }

    public void follow(final MethodReference methodReference) {
        System.out.println("Follow " + methodReference.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
    
    public static void main(String[] args){

        // 第一种方法引用是构造方法引用，语法是：Class::new ，对于泛型来说语法是：Class<T>::new，请注意构造方法没有参数
        final MethodReference me = MethodReference.create(MethodReference::new);

        final List<MethodReference> methodReferenceList = Arrays.asList(me);

        // 第二种方法引用是静态方法引用，语法是：Class::static_method请注意这个静态方法只支持一个类型为MethodReference的参数。
        methodReferenceList.forEach(MethodReference::collide);

        // 第三种方法引用是类实例的方法引用，语法是：Class::method请注意方法没有参数。
        methodReferenceList.forEach(MethodReference::repair);

        // 最后一种方法引用是引用特殊类的方法，语法是：instance::method，请注意只接受MethodReference类型的一个参数。
        final MethodReference methodReference = MethodReference.create(MethodReference::new);
        methodReferenceList.forEach(methodReference::follow);
    }

}
