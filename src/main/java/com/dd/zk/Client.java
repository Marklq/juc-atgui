package com.dd.zk;

/**
 * @Package: com.dd.zk
 * @ClassName: Client
 * @Author: 东方不败
 * @CreateTime: 2020-10-06 10:52
 * @Description:
 */
public class Client {


    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {

            new Thread(() -> {
                new OrderService().getOrderNum();
            }, String.valueOf(i)).start();
        }
    }

}
