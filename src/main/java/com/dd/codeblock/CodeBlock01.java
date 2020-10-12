package com.dd.codeblock;

public class CodeBlock01 {
    public static void
    main(String[] args) {
        {
            int x = 11;
            System.out.println("普通代码块内的变量x=" + x);
        }
        {
            int y = 13;
            System.out.println("普通代码块内的变量y=" + y);
        }
        int x = 12;
        System.out.println("主方法内的变量x=" + x);
    }
}