package com.yang.thread;

import java.util.concurrent.TimeUnit;

public class HelloVolatile {
    volatile boolean running = true;
    /*
    1.volatile修饰的内存，只要修改，就会同步涉及到的每个线程（保持可见性）
    2.volatile修饰的内存，不可以重排序，就是对该变量的所有读操作和写操作不可以换顺序
     */
    void m(){
        System.out.println("m start!");
        while(running){
            //System.out.println("hello!"); //这句话有刷新内存的操作，即某个线程更改了变量的值，会通知另一个线程进行值刷新
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        HelloVolatile t = new HelloVolatile();

        new Thread(t::m, "t1").start();
        /*
        如何理解并使用Java中双冒号::运算操作符   在这里是引用特定对象实例方法
        https://www.bilibili.com/read/cv8023087
         */

        try{
            TimeUnit.MILLISECONDS.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        t.running = false;
    }
}
