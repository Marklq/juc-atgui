package com.dd.juc;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Package: com.dd.juc
 * @ClassName: CyclicBarrierDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-09 10:57
 * @Description:
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("=======召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {

            final int temInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" +"收集到第"+temInt+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }
}
