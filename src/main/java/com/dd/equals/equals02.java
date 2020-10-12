package com.dd.equals;

/**
 * @Package: com.dd
 * @ClassName: equals02
 * @Author: 东方不败
 * @CreateTime: 2020-10-05 18:40
 * @Description:
 */
public class equals02 {

    public static void main(String[] args) {

        String S1 = "abc";//常量池中
        String S2 = new String("abc");//堆中
        String S3 = "abc";
        String S4 = "xxx";
        String S5 = "abc" + "xxx";//字符串的拼接相当于生成一个新的对象
        String S6 = S3 + S4;
        System.out.println(S1 == S2);
        System.out.println(S1 == S5);
        System.out.println(S1 == S6);


        //intern-----从字符串常量池中去找有没有
        System.out.println(S1 == S6.intern());
        System.out.println(S2 == S2.intern());

    }
}
