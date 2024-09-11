package com.yang.basic;

public class Overload {
    public final void sayHello(){
        System.out.println("欢迎大家！");
    }

    public void sayHello(String name){
        System.out.println("欢迎"+name);
    }

    public static void main(String[] args) {
        new Overload().sayHello("张三");
    }
}
