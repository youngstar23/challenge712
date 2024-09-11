package com.yang.basic.InnerClass;

//静态内部类 不能使用 外部类的 非static成员变量 和 成员方法
public class Outer3 {
    private int age1 = 10;
    private static int age2 = 20;

    static class Inner{
        public void method(){
            System.out.println(age2);
        }
    }

    public static void main(String[] args) {
        Outer3.Inner inner = new Outer3.Inner();
        inner.method();
    }
}
