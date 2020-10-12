package com.dd.codeblock;

class Code { //随从类 次类
    public Code() {
        System.out.println("Code的构造方法1111");
    }

    {
        System.out.println("Code的构造块2222");
    }

    static {
        System.out.println("Code的静态代码块3333");
    }
}

public class CodeBlock03 { //主类CodeBlock03.class ===> CodeBlock03 class
    {
        System.out.println("CodeBlock03的构造块444");
    }

    static {
        System.out.println("CodeBlock03的静态代码块555");
    }

    public CodeBlock03() {
        System.out.println("CodeBlocke3的构造方法666");
    }

    public static void main(String[] args) {
        System.out.println("==我是美丽分割线========CodeBlocke3的main方法777");
        new Code();
        System.out.println("---------");
        new Code();
        System.out.println("----------");
        new CodeBlock03();
    }
}