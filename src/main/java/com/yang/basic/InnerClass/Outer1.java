package com.yang.basic.InnerClass;

//成员内部类
public class Outer1 {
    private int age = 20;

    class InnerClass{
        //成员内部类不能含有 static 的变量和方法。 可以有static final
        private static final int grade = 10;
        public void show(){
            System.out.println(age);
        }
    }

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Outer1.InnerClass innerClass = outer1.new InnerClass();
        innerClass.show();
    }
}
