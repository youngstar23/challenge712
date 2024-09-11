package com.yang.thread;

import org.openjdk.jol.info.ClassLayout;

public class Test {
    //private static Object object = new Object();

    public static void main(String[] args) {
        Object object = new Object();

        System.out.println(ClassLayout.parseInstance(object).toPrintable());

        synchronized (object){ //修改对象头记录的锁信息
            System.out.println(ClassLayout.parseInstance(object).toPrintable());
        }
    }
}
