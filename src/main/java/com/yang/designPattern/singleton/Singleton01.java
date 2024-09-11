package com.yang.designPattern.singleton;

//java单例模式---详解JAVA单例模式及其8种实现方式

/*
确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
在计算机系统中，线程池、缓存、日志对象、对话框、打印机、显卡的驱动程序对象常被设计成单例。
这些应用都或多或少具有资源管理器的功能。
每台计算机可以有若干个打印机，但只能有一个Printer Spooler，以避免两个打印作业同时输出到打印机中。
每台计算机可以有若干通信端口，系统应当集中管理这些通信端口，以避免一个通信端口同时被两个请求同时调用。
总之，选择单例模式就是为了避免不一致状态，避免政出多头。
 */

//1.饿汉式单例
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){}

    public static Singleton01 getInstance(){return INSTANCE;}

    public static void main(String[] args) {
        Singleton01 singleton01 = Singleton01.getInstance();
        Singleton01 singleton02 = Singleton01.getInstance();
        System.out.println(singleton01 == singleton02);
    }
}

/*
饿汉式（静态常量）【可用】
优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
 */
