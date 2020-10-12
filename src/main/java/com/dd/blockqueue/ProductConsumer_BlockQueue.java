package com.dd.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {

    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProduct() throws Exception {
        String data = null;
        boolean offer;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            offer = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (offer) {
                System.out.println(Thread.currentThread().getName() + "\t生产者生产：" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t生产者生产：" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t生产结束");
    }

    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t超过两秒没有进行消费，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费队列消费:" + result + "成功");
        }
    }

    public void stop() {
        this.FLAG = false;
    }


}

/**
 * @Package: com.dd.blockqueue
 * @ClassName: ProductConsumer_BlockQueue
 * @Author: 东方不败
 * @CreateTime: 2020-10-09 21:54
 * @Description:
 */
public class ProductConsumer_BlockQueue {

    public static void main(String[] args) {

        //MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        MyResource myResource = new MyResource(new LinkedBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产者线程启动");
            try {
                myResource.myProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Productor").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费者线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        //使生产消费的整个活动持续五秒钟结束
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("==========================================================");
        System.out.println(Thread.currentThread().getName() + "\tmain线程终止整个生产消费");
        myResource.stop();
    }
}
