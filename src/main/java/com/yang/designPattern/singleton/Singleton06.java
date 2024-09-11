package com.yang.designPattern.singleton;

public class Singleton06 {
    private static Singleton06 INSTANCE;

    private Singleton06(){}

    public static Singleton06 getInstance(){ //Double Check Lock
        if(INSTANCE == null){
            synchronized (Singleton06.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton06();
                }
            }
        }
        return INSTANCE;
    }
}

/*
Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，
我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
优点：线程安全；延迟加载；效率较高。
 */


/*
INSTANCE 需不需要加volatile？

需要，因为
Object object = new Object();
操作是有三个步骤，分别是在堆中申请一块内存，对象初始化，栈中的符号和堆中的内存建立关联

如果不加volatile，在过程中发生指令重排，则出现一个线程拿到的INSTANCE，可能还没有对象初始化，
也就是相当于指向内存中的数据是随机的，这是非常可怕的。

如果加了volatile，则在后来初始化过程完成后，要通知其他线程修改这个值。
 */