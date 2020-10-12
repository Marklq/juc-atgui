package com.dd.deadLock;


import java.util.concurrent.TimeUnit;

class MyLock implements Runnable {

    private final String lockA;
    private final String lockB;

    public MyLock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t自己持有" + lockA + "\t尝试获取" + lockB);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t自己持有" + lockB + "\t尝试获取" + lockA);

            }
        }
    }
}


/**
 * @Package: com.dd.deadLock
 * @ClassName: deadLockDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-10 17:24
 * @Description: 死锁是指两个或两个以上的进程在执行过程中,
 * 因争夺资源而造成的一种 互相等待的现象，
 * 若无外力干涉那它们都将无法推进下去.
 */
public class deadLockDemo {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new MyLock(lockA, lockB), "Thread1").start();
        new Thread(new MyLock(lockB, lockA), "Thread2").start();
    }


}
