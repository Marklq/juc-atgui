package com.dd.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.dd.juc
 * @ClassName: SemphoreDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-09 11:06
 * @Description:
 */
public class SemaphoreDemo {

    static Semaphore semaphore = new Semaphore(3);//模拟三个车位

    public static void main(String[] args) {

        for (int i = 1; i <= 6; i++) {//模拟六辆车

            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t" + "抢到了车位");
                    TimeUnit.SECONDS.sleep(3);//占用车位3秒
                    System.out.println(Thread.currentThread().getName() + "\t" + "离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();

        }
    }
}
