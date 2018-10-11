package com.ly.jvm;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Author: liyan
 * @Description:
 * @Date: Created in 18:25 2018/9/13
 * @Modified By:
 */
public class ReferenceType {
    private String type;
    private String des;

    public ReferenceType(String type, String des) {
        this.type = type;
        this.des = des;
    }

    @Override
    public String toString() {
        return "[type: " + type + " des: " + des + "]";
    }

    public static void main(String[] args) {
        // 强引用
        ReferenceType people_Strong = new ReferenceType("strong", "strong");
        System.out.println(people_Strong); // [type: strong des: strong]
        System.gc();
        System.out.println(people_Strong); // [type: strong des: strong]

        // 软引用
        SoftReference<ReferenceType> softReference = new SoftReference<ReferenceType>(new ReferenceType("soft","soft"));
        System.out.println(softReference.get()); // [type: soft des: soft]
        System.gc();
        System.out.println(softReference.get()); // [type: soft des: soft]

        // 弱引用
        WeakReference<ReferenceType> weakReference = new WeakReference<ReferenceType>(new ReferenceType("weak",  "weak"));
        System.out.println(weakReference.get()); // [type: weak des: weak]
        System.gc();
        System.out.println(weakReference.get()); // null

        // 虚引用
        ReferenceQueue<ReferenceType> referenceReferenceQueue = new ReferenceQueue<>();
        PhantomReference<ReferenceType> phantomReference = new PhantomReference<ReferenceType>(new ReferenceType("phantom", "phantom"), referenceReferenceQueue);
        System.out.println(phantomReference.get()); // null
        System.gc();
        System.out.println(phantomReference.get()); // null

    }

}
