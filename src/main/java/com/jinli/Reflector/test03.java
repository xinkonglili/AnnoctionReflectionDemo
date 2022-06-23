package com.jinli.Reflector;

//测试Class的创建方式
public class test03 {
    public static void main(String[] args) throws ClassNotFoundException {
         Person person = new Student();
         /**
          * 这个人是：学生
          * hashCode is:460141958
          * hashCode is:460141958
          * hashCode is:460141958
          * hashCode is:1163157884
          * */
        System.out.println("这个人是：" + person.name);

        //
        Class c1 = person.getClass();
        System.out.println("hashCode is:" + c1.hashCode());

        //
        Class c2 = Class.forName("com.jinli.Reflector.Student");//要抛出异常
        System.out.println("hashCode is:" + c2.hashCode());

        //
        Class<Student> c3 = Student.class;
        //Class c3 = Student.class;  //相等的
        System.out.println("hashCode is:" + c3.hashCode());

        //
        Class c4 = Integer.TYPE;
        System.out.println("hashCode is:" + c4.hashCode()); //hashCode is:1163157884
        System.out.println("TYPE is:" + c4); //TYPE is:int

        //
        Class c5 = c1.getSuperclass();
        System.out.println(c5); //class com.jinli.Reflector.Person



    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student(){
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}