package com.dd.threadPool;

import java.util.concurrent.*;

/**
 * @Package: com.dd.threadPool
 * @ClassName: MyThreadPoolDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-10 16:39
 * @Description:
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {


        //获取CPU内核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        //最大线程数就是是maxpoolsize加上阻塞队列数
        try {
            for (int i = 0; i < 20; i++) {
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
