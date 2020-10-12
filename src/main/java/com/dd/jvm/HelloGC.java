package com.dd.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @Package: com.dd.jvm
 * @ClassName: HelloGC
 * @Author: 东方不败
 * @CreateTime: 2020-10-10 21:22
 * @Description:
 */
public class HelloGC {


    public static void main(String[] args) {

        System.out.println("HEllo GC ");
//        byte[] bytes = new byte[50 * 1024 * 1024];
/*        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

/*
        long totalMemory = Runtime.getRuntime().totalMemory();//返回 Java虚拟机中的内存总量。
        long maxMemory = Runtime.getRuntime().maxMemory();//返回 Java虚拟机试图使用的最大内存量。
        System.out.println("TOTAL_MEMORY(-Xms)=" + totalMemory + "(字节)、" + (totalMemory / 1024 / 1024) + "MB");
        System.out.println("MAX_MEMORY(-Xmx) =" + maxMemory + "(字节)、" + (maxMemory / 1024 / 1024) + "MB");
*/


    }
}
