package com.dd.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {

    public synchronized void sendSms() {
        System.out.println(Thread.currentThread().getId() + "\t" + "调用发短信");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "\t" + "调用发邮件");
    }

    @Override
    public void run() {
        get();
    }

    Lock lock = new ReentrantLock();

    public void get() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getId() + "\t" + "调用get");
            put();
        } finally {
            lock.unlock();
        }
    }

    public void put() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getId() + "\t" + "调用put");
        } finally {
            lock.unlock();
        }
    }
}


/**
 * @Package: com.dd.lock
 * @ClassName: RenntrentLockDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-08 17:56
 * @Description:
 */
public class RenntrentLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();
        //sync
        new Thread(phone::sendSms, "t1").start();
        new Thread(phone::sendSms, "t2").start();
        //lock
        new Thread(phone::get, "t3").start();
        new Thread(phone::get, "t4").start();
    }

}
