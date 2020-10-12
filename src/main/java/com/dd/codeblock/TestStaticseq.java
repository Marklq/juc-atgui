package com.dd.codeblock;

class Father {
    public Father() {
        System.out.println("111111");
    }

    {
        System.out.println("222222");
    }

    static {
        System.out.println("333333");
    }
}

class Son extends Father {
    public Son() {
        System.out.println("444444");
    }

    {
        System.out.println("555555");
    }

    static {
        System.out.println("666666");
    }
}

public class TestStaticseq { //TestStaticseq Classs
    static {
        System.out.println("主类中的静态方法块");
    }

    public static void main(String[] args) {
        System.out.println("77777777777");
        new Son();
        System.out.println("==================");
        new Son();
        System.out.println("==================");
        new Father();
    }

}


