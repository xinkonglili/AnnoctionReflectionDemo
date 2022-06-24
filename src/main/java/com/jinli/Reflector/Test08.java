package com.jinli.Reflector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test08 {
    //获取类的信息
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.jinli.Reflector.User");
        //User user = new User();
        //String c1 = user.getName();
        //1、获取类的名字
        System.out.println(c1.getName());//获取包名+类名  com.jinli.Reflector.User
        System.out.println(c1.getSimpleName());//获取包名 User

        //获取类的属性
        /*
        *   private int id;
            private int age;
            private String name;*/
        Field[] fields = c1.getFields();//打印不出来，因为只能获取公开的属性
        System.out.println("-----------------------------------");
        //快捷打印field.for
        for (Field field : fields) {
            System.out.println(field);
        }
        //这样代码可以直接拿过来用
        /*
        * private int com.jinli.Reflector.User.id
        * private int com.jinli.Reflector.User.age
          private java.lang.String com.jinli.Reflector.User.name
          * */
        fields = c1.getDeclaredFields();//可以找到全部的属性
        for (Field field : fields) {//循环fields
            System.out.println(field);//输出field
        }

        //获取指定的属性--->private java.lang.String com.jinli.Reflector.User.name
        Field name = c1.getDeclaredField("name");//getField()打印不出来
        System.out.println(name);

        System.out.println("------------------------------------------");
        //获得类的方法
        Method[] classMethods = c1.getDeclaredMethods(); //获取本类的所有方法，可以获取本类私有的
         /*
        public java.lang.String com.jinli.Reflector.User.toString()
        public java.lang.String com.jinli.Reflector.User.getName()
        public void com.jinli.Reflector.User.setName(java.lang.String)
        public int com.jinli.Reflector.User.getId()
        public void com.jinli.Reflector.User.setAge(int)
        public int com.jinli.Reflector.User.getAge()
        public void com.jinli.Reflector.User.setId(int)

        private void com.jinli.Reflector.User.test() 可以获取本类私有的
        * */
        for (Method method : classMethods) {
            System.out.println(method);
        }

        System.out.println("------------------------------------------");

        Method[] methods = c1.getMethods(); //获取子类和父类的所有public方法，获取不到private
        /*  正常的：public java.lang.String com.jinli.Reflector.User.toString()
            正常的：public java.lang.String com.jinli.Reflector.User.getName()
            正常的：public void com.jinli.Reflector.User.setName(java.lang.String)
            正常的：public int com.jinli.Reflector.User.getId()
            正常的：public int com.jinli.Reflector.User.getAge()
            正常的：public void com.jinli.Reflector.User.setAge(int)
            正常的：public void com.jinli.Reflector.User.setId(int)
            正常的：public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
            正常的：public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
            正常的：public final void java.lang.Object.wait() throws java.lang.InterruptedException
            正常的：public boolean java.lang.Object.equals(java.lang.Object)
            正常的：public native int java.lang.Object.hashCode()
            正常的：public final native java.lang.Class java.lang.Object.getClass()
            正常的：public final native void java.lang.Object.notify()
            正常的：public final native void java.lang.Object.notifyAll()
            */
        for (Method method : methods) {
            System.out.println("正常的："+ method);
        }


        //获取指定的方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);//丢进去参数的类型，通过类型来判断需要的是哪个方法-->重载
        System.out.println(getName);//public java.lang.String com.jinli.Reflector.User.getName()
        System.out.println(setName);// public void com.jinli.Reflector.User.setName(java.lang.String)


    }
}
