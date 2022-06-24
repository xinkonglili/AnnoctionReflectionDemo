package com.jinli.Reflector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//性能检测测试
public class test10 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        test01();
        test02();
        test03();

    }
    //普通方法执行时间：0
    //未检测反射方法执行时间：1772  反射效率低
    //检测反射方法执行时间：1024   不使用检测：getName.setAccessible(true);
    //通过普通的方式创建
    public static void test01(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0;i < 2000000000; i++){
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方法执行时间："+(endTime-startTime));

    }

    //通过反射的调用，使用检测
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        //通过Class对象创建对象
        Class c2 = Class.forName("com.jinli.Reflector.User");
        User user1 = (User) c2.newInstance();
        //获取对象的Class对象
        Class c1 = user1.getClass();
        //通过获取的Class对象，获取类的方法
        Method getName = c1.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();
        for (int i = 0;i < 2000000000; i++){
            getName.invoke(user1,null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("未检测反射方法执行时间："+(endTime-startTime));

    }



    //通过反射的方式调用，关闭检测
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user2 = new User();
        Class c1 = user2.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0;i < 2000000000;i++){
            getName.invoke(user2,null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("检测反射方法执行时间："+(endTime-startTime));

    }

}



