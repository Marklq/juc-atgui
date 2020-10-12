package com.dd.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类
class Resource {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                //等待，不能再生产
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //判断
            //使用while而不使用if的原因，防止线程虚假唤醒。API 官方文档建议使用while
            while (number == 0) {
                //等待，不能再生产
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * @Package: com.dd.blockqueue
 * @ClassName: ProductConsumer_traditional
 * @Author: 东方不败
 * @CreateTime: 2020-10-09 17:57
 * @Description:
 */
public class ProductConsumer_traditional {

    public static void main(String[] args) {
        Resource resource = new Resource();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    resource.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "AAA").start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    resource.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "BBB").start();
        }
    }

}
