package com.dd.jvm.oom;

/**
 * @Package: com.dd.jvm.oom
 * @ClassName: OverFlowStackErrorDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-11 17:01
 * @Description:
 */
public class OverFlowStackErrorDemo {

    public static void main(String[] args) {
        stackOverflowError();
    }

    public static void stackOverflowError() {
        stackOverflowError();
    }
}
