package com.yang.basic.InnerClass;

//局部内部类
public class Outer2 {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.test();
    }

    public void test(){
        final double PI = 3.14;
        int r = 6;
        class Circle implements Type{
            @Override
            public double area() {
                return PI * r * r;
            }
        }
        Circle circle = new Circle();
        System.out.println(circle.area());
    }
}

interface Type{
    public double area();
}
