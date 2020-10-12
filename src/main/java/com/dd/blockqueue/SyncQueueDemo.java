package com.dd.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Package: com.dd
 * @ClassName: blockQueue
 * @Author: 东方不败
 * @CreateTime: 2020-10-09 17:28
 * @Description:
 */
public class SyncQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "put a ");
                queue.put("a");
                System.out.println(Thread.currentThread().getName() + "\t" + "put b ");
                queue.put("b");
                System.out.println(Thread.currentThread().getName() + "\t" + "put c ");
                queue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t" + "take" + queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t" + "take" + queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + "\t" + "take" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
