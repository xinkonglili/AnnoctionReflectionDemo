package com.jinli.Reflector;

public class test02 extends Object{
    //要抛异常
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.jinli.Reflector.User");
        Class c2 = Class.forName("com.jinli.Reflector.User");
        Class c3 = Class.forName("com.jinli.Reflector.User");
        Class c4 = Class.forName("com.jinli.Reflector.User");
        System.out.println("得到的对象："+c1);//打印对象形式：class com.jinli.Reflector.User
        /**
         * 打印hashcode-->460141958
         打印hashcode-->460141958
         打印hashcode-->460141958
         1、一样的hashcode：说明只有一个Class对象，一个类在内存中只有一个Class对象，
         2、一个类被加载之后，整个类的结构就会被封装在Class对象之中
         3、Object中有getClass方法，该方法将被所有的子类继承
         */
        System.out.println("打印hashcode-->"+c2.hashCode());
        System.out.println("打印hashcode-->"+c3.hashCode());
        System.out.println("打印hashcode-->"+c4.hashCode());
    }
}

class User{
    private int id;
    private int age;
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void test(){
        System.out.println("测试");
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
