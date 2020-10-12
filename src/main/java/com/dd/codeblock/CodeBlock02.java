package com.dd.codeblock;

public class CodeBlock02 {
    {
        System.out.println("第=二构造块333");
    }

    public CodeBlock02() {
        System.out.println("构造方法222");
    }

    {
        System.out.println("第一代码块111");
    }

    public static void main(String[] args) {
        new CodeBlock02();
        System.out.println("=====================");
        new CodeBlock02();
    }
}