package com.dd.zk;

/**
 * @Package: com.dd.zk
 * @ClassName: OrderNumber
 * @Author: 东方不败
 * @CreateTime: 2020-10-06 9:40
 * @Description:
 */
public class OrderNumber {

    public static int num = 0;

    public String getNum() {
        return "生成订单号" + "\t" + (++num);
    }

}
