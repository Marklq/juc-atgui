package com.dd.jvm.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
    /*
     * 内存够用的时候就保留，不够用就回收
     * */
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    //-Xms=5m -Xmx=5m  设置JVM参数
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    public static void main(String[] args) {
        //内存够用情况下
        //softRef_Memory_Enough();

        //内存不够的情况下
        softRef_Memory_NotEnough();
    }
}
