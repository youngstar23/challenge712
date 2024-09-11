package com.yang.thread.interviewA1B2C3;

public class SyncWaitNotify {
    public static void main(String[] args) {
        final Object object = new Object();

        char[] an = "1234567".toCharArray();
        char[] al = "ABCDEDF".toCharArray();

        new Thread(() -> {
            synchronized (object){
                for (char c : an) {
                    System.out.print(c);
                    try{
                        object.notify(); //唤醒竞争这把锁的其他线程
                        object.wait(); //本线程让出这把锁（也就是阻塞本线程）
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                object.notify(); //必须，否则无法终止程序
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (object){
                for (char c : al) {
                    System.out.print(c);
                    try{
                        object.notify();
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                object.notify(); //必须，因为不知道t1 t2的执行顺序
            }
        }, "t2").start();
    }
}
