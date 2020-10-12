package com.dd.zk;

/**
 * @Package: com.dd.zk
 * @ClassName: OrderService
 * @Author: 东方不败
 * @CreateTime: 2020-10-06 10:47
 * @Description:
 */
public class OrderService {

    private final OrderNumber orderNumber = new OrderNumber();
    private final IZKLock izkLock = new ZkDistributedLock();


    public void getOrderNum() {

        try {
            izkLock.zklock();
            System.out.println("获得编号：" + orderNumber.getNum());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            izkLock.zkunlock();
        }
    }


}
