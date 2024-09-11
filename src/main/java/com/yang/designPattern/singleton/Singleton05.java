package com.yang.designPattern.singleton;

public class Singleton05 {
    private static Singleton05 INSTANCE;

    private Singleton05(){}

    public static Singleton05 getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton05.class){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                INSTANCE = new Singleton05();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton05.getInstance().hashCode());
            }).start();
        }
    }
}

/*
懒汉式（线程安全，同步代码块）【不可用】
由于第四种实现方式同步效率太低，所以摒弃同步方法，改为同步产生实例化的的代码块。
但是这种同步并不能起到线程同步的作用。
跟第3种实现方式遇到的情形一致，假如一个线程进入了if (singleton == null)判断语句块，
还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 */
