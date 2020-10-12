package com.dd.jvm.oom;

/**
 * @Package: com.dd.jvm.oom
 * @ClassName: OutOfMemoryDemo
 * @Author: 东方不败
 * @CreateTime: 2020-10-11 17:12
 * @Description:
 */
public class OutOfMemoryDemo {

    public static void main(String[] args) {

        byte[] bytes = new byte[20 * 1024 * 1024];

    }

}
