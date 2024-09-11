package com.yang.thread;

class MyThread implements Runnable{

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++){
            System.out.println(Thread.currentThread().getName()+
                    "运行，i=" + i);
        }
    }
}
public class Join {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread, "线程A");
        t.start();
        for (int i = 0; i < 10; i++) {
            if(i > 2){
                try {
                    t.join(); //join()的作用，是让主线程会等待子线程结束之后才能继续运行
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Main线程运行--->" + i);
        }
    }
    /*
    A.join:在API中的解释是：堵塞当前线程B，直到A执行完毕并死掉，再执行=>A先执行完，再执行B;
    A.yield:A让出位置，给B执行，B执行结束后A再执行，跟join的意思正好相反
     */
}
