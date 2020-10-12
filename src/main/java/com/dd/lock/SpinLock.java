package com.dd.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Package: com.dd.lock
 * @ClassName: SpinLock
 * @Author: 东方不败
 * @CreateTime: 2020-10-08 21:54
 * @Description: 题目:实现一个自旋锁
 * 自旋锁好处:循环比较国取直到成功为止，没有类liwait的阻塞。
 * 通过CAS操作完成自旋锁，A线程先进来调用myLock.方法自己持有锁5秒钟，B随后进来后发现
 * 当前有线程持有锁，不是null,所以只能通过自旋等待，直到A释放锁后B随后抢到。
 */
public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t" + "调用 lock方法");

        //自旋锁核心--->  CAS + while
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myunlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "调用 unlock方法");

    }


    public static void main(String[] args) {
        SpinLock lock = new SpinLock();

        new Thread(() -> {
            lock.mylock();
            //暂停5秒，模拟业务
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.myunlock();
        }, "AAA").start();


        new Thread(() -> {
            lock.mylock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.myunlock();
        }, "BBB").start();


    }

}
