package com.jinli.Reflector;

import java.sql.SQLOutput;

public class test06 {

    static {
        System.out.println("Main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        /*Main类被加载
        父类静态代码块被加载
        子类静态代码块被加载
        */
        //1、主动引用-->new对象
        //Son son = new Son();

        //2、反射也可以被主动引用--->耗资源
        //Class.forName("com.jinli.Reflector.Son");//抛异常

        //不会产生类的引用的方法
         /*  Main类被加载
            父类静态代码块被加载
            10*/
        //System.out.println(Son.b); //子类去调用父类的静态变量，子类不会被加载

        //数组不会发生类加载
        //Main类被加载
        //Son[] array = new Son[5];

        //常量不会引起类初始化（子类和父类）--->因为在链接的时候就已经存入调用类的常量池中了
        /*
        * Main类被加载
            500
         */
        System.out.println(Son.n);
    }
}

class Father{
    static int b = 10;
    static {
        System.out.println("父类静态代码块被加载");
    }

}

class Son extends Father{
    static {
        System.out.println("子类静态代码块被加载");
        m = 300;
    }
    static int m = 100;
    static final int n = 500;

}
