package com.yang.thread.interviewA1B2C3;

/*public class Output {
    private static volatile Boolean bt = true;
    private static volatile Boolean bf = false;
    public static void main(String[] args) {
        new Thread(() -> {
            int i = 1;
            synchronized (bt){
                if(bt){
                    System.out.print(i);
                    bt = false;
                    bf = true;
                    ++i;
                }
            }
        }).start();
        new Thread(() -> {
            int i = 0;
            synchronized (bf) {
                if (bf) {
                    System.out.print((char)('A'+i));
                    bf = false;
                    bt = true;
                    ++i;
                }
            }
        }).start();
    }
}*/


import java.util.concurrent.locks.LockSupport;

public class LockSupportExam {
    private static Thread t1;
    private static Thread t2;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.print(i);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });
        t2 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                LockSupport.park();
                System.out.print((char)(i+'A'));
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();
    }
}
