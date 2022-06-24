package com.jinli.Reflector;

//类加载器加载class字节码文件，把类（class）加载到内存
public class test07 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
            sun.misc.Launcher$AppClassLoader@18b4aac2
            sun.misc.Launcher$ExtClassLoader@1b6d3586
            null*/
        //获取系统加载器--->AppClassLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统加载器的父类加载器--->扩展类加载器-->ExtClassLoader
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取父类加载器的根加载器--->c/c++加载器，该加载器无法获取，返回null
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //test 当前类是哪个加载器加载的--sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader = Class.forName("com.jinli.Reflector.test07").getClassLoader();
        System.out.println(classLoader);

        //testJDK内部类是上加载的--->null
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);


        //如何获得类加载器加载的path
        System.out.println(System.getProperty("java.class.path"));
        /*
        * D:\software\jdk8\jdk1.8\jre\lib\charsets.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\access-bridge-64.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\cldrdata.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\dnsns.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\jaccess.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\jfxrt.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\localedata.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\nashorn.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\sunec.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\sunjce_provider.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\sunmscapi.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\sunpkcs11.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\ext\zipfs.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\jce.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\jfr.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\jfxswt.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\jsse.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\management-agent.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\resources.jar;
        * D:\software\jdk8\jdk1.8\jre\lib\rt.jar;
        * D:\JAVASTUDY\AnnoctionReflectionDemo\target\classes;
        * D:\software\idea\IntelliJ IDEA 2022.1.2\lib\idea_rt.jar
         */


    }
}
