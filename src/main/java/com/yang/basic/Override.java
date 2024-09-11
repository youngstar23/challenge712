package com.yang.basic;

class Father{
    public void sayHello(){
        System.out.println("我是父亲");
    }
}

class Son extends Father{
    public void sayHello(){
        System.out.println("我是孩子");
    }
}

public class Override {
    public static void main(String[] args) {
        Father f = new Son();
        f.sayHello();
    }
}
