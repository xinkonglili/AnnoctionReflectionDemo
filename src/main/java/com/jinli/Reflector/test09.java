package com.jinli.Reflector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        //获得一个Class对象
        Class c1 = Class.forName("com.jinli.Reflector.User");

        //构造一个对象-->通过Class对象构建对象
        //User user = (User)c1.newInstance();//本质是调用了类的无参构造器
        //System.out.println(user);//User{id=0, age=0, name='null'}

        //通过构造器创建对象-->没有无参构造器也能创建成功
        //Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        /*User user1 =(User) constructor.newInstance("jinli", 001, 18);
        System.out.println(user1);*/

        //通过反射调用普通方法
        User user2 = (User)c1.newInstance();
         //通过反射获取一个方法
        Method setName  = c1.getDeclaredMethod("setName", String.class); //可以没有无参构造器
        //通过invoke()进行调用，如果方法为私有的，要在invoke之前调用setName.setAccessible(true)
        setName.invoke(user2,"瑾里");
        System.out.println(user2.getName());

        //通过反射操作属性
        User user3 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");//可以没有无参构造器
        //不能直接操作私有属性，我们需要关闭程序的安全检测setAccessible(true)
        name.setAccessible(true);
        name.set(user3,"lpvh");
        System.out.println(user3);

    }
}
