package com.yang.basic;

import static  java.lang.Math.*;

public class FinalWriteDemo {
    private int a;
    private final int b;
    private static FinalWriteDemo finalWriteDemo;

    public FinalWriteDemo(){
        a = 1;
        b = 2;
    }

    public static void writer(){
        finalWriteDemo = new FinalWriteDemo();
    }

    public static void reader(){
        FinalWriteDemo object = finalWriteDemo;
        int a = object.a;
        int b = object.b;
    }

    public static void main(String[] args) {
        System.out.println(random());
    }
}
