package com.yang.basic.oop;

class TestBlock{
    private static int count = 0;
    public TestBlock(){
        System.out.println("构造代码块"+count+"测试执行");
        ++count;
    }
    static {
        System.out.println("静态代码块测试执行");
    }
    {
        System.out.println("普通代码块"+count+"测试执行");
    }
}

public class ThreeBlock {
    static {
        System.out.println("我测试一下谁先被执行");
    }
    public static void main(String[] args) {
        //new TestBlock();
        //new TestBlock();
        System.out.println("你好啊，这个世界！");
    }
}

