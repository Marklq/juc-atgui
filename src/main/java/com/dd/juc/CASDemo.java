package com.dd.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Package: com.dd.juc
 * @ClassName: CASDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-05 11:20
 * @Description:
 */
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);


        //expect:期望的比较值  set：为 true 后 修改成的值
        boolean compareAndSet = atomicInteger.compareAndSet(5, 2020);

        System.out.println(compareAndSet + "" + atomicInteger.get());

        boolean compareAndSet2 = atomicInteger.compareAndSet(5, 1111);

        System.out.println(compareAndSet2 + "" + atomicInteger.get());

    }

}
