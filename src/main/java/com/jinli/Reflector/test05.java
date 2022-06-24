package com.jinli.Reflector;

//类加载
public class test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.m);
    }
}
/**
 * 明白Class对象什么时候生成的？
 * static什么时候给他分配的内存？---->这些内存都是在方法区时分配的。
 * 1、加载到内存，生成Class对象
 * 2、链接，结束之后m=0
 * 3、初始化：----static合并，通过类构造器<clinit></clinit>()合并
 *    static {
 *         System.out.println("A类静态代码块初始化");//先执行
 *         int m = 300;
 *         static int m = 100;
 *     }
 *     */

/**
 * A类静态代码块初始化
 A类的无参构造
 100*/

class A{

    public A(){
        System.out.println("A类的无参构造");
    }

    //静态代码块
    static {
        System.out.println("A类静态代码块初始化");//先执行
        int m = 300;
    }
    //全局变量
    static int m = 100;

    //无参构造

}
