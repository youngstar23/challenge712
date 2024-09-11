package com.yang.thread;

public class Join2 {
    static class Join2Thread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Join2Thread(), "t1");
        Thread t2 = new Thread(new Join2Thread(), "t2");
        t1.start();
        t1.join();
        /*
        关于join方法其实还可以提交过期时间，也就是在执行到达预定时间后，执行方式将继续以并行的方式执行。
        t1.join(10);//表示10ms后，将结束join。
         */
        t2.start();
    }
}
