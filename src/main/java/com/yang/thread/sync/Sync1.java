package com.yang.thread.sync;

// https://blog.csdn.net/qq_21383435/article/details/111502642

public class Sync1 implements Runnable{
    private static final Sync1 INSTANCE = new Sync1();

    private static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(INSTANCE);
        Thread t2 = new Thread(INSTANCE);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
