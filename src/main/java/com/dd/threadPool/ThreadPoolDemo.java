package com.dd.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @Package: com.dd.threadPool
 * @ClassName: ThreadPoolDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-10 13:59
 * @Description:
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        //Cpu核数
        //   System.out.println(Runtime.getRuntime().availableProcessors());

        //一池五个处理线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一池一个处理线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //一池N个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }


}
