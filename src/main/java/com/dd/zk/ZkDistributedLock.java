package com.dd.zk;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * @Package: com.dd.zk
 * @ClassName: zkImpl
 * @Author: 东方不败
 * @CreateTime: 2020-10-06 10:31
 * @Description:
 */
public class ZkDistributedLock extends ZkAbstractTemplateLock {


    @Override
    public boolean tryZklock() {

        //创建临时节点
        try {
            zkClient.createEphemeral(path);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Override
    public void waitZklock() {

        IZkDataListener iZkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };

        //加载监听器
        zkClient.subscribeDataChanges(path, iZkDataListener);

        if (zkClient.exists(path)) {
            //只能等待，不能进行下一步
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        //解除监听器
        zkClient.unsubscribeDataChanges(path, iZkDataListener);
    }

}
