package com.dd.zk;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.dd.zk
 * @ClassName: ZkTemaplateLock
 * @Author: 东方不败
 * @CreateTime: 2020-10-06 9:43
 * @Description:
 */
public abstract class ZkAbstractTemplateLock implements IZKLock {

    public static final String ZK_SERVER = "192.168.218.129:2181";
    public static final int ZK_TIMEOUT = 45 * 1000;
    ZkClient zkClient = new ZkClient(ZK_SERVER, ZK_TIMEOUT);

    protected String path = "/zk-dd";
    protected CountDownLatch countDownLatch = null;

    @Override
    public void zklock() {

        if (tryZklock()) {
            System.out.println(Thread.currentThread().getName() + "------获取锁成功");
        } else {
            waitZklock();
            zklock();
        }

    }

    public abstract boolean tryZklock();

    public abstract void waitZklock();


    @Override
    public void zkunlock() {

        //清除临时节点
        if (zkClient != null) {
            zkClient.close();
        }
        System.out.println(Thread.currentThread().getName() + "-----------释放锁成功");
        System.out.println();
        System.out.println();
    }

}
