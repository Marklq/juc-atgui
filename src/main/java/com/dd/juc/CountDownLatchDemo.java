package com.dd.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.dd.juc
 * @ClassName: CountDownLatchDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-09 10:24
 * @Description:
 */
public class CountDownLatchDemo {

    private static final Integer NUM = 6;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(NUM);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "start");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t" + "end");
    }

}
