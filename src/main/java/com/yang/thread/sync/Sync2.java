package com.yang.thread.sync;

public class Sync2 implements Runnable {

    private static final Sync2 instance = new Sync2();

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        // 线程还存在
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("线程执行结束");
    }

    Object lock1 = new Object();
    Object lock2 = new Object();

    @Override
    public void run() {
        // 第一把锁
        synchronized (lock1) {
            System.out.println("我是lock1，我叫"+ Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock1运行结束");
        }

        // 第二把锁
        synchronized (lock2) {
            System.out.println("我是lock2，我叫"+ Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"lock2运行结束");
        }
    }
}
