package com.yang.basic.exception;

abstract class Animal{
    abstract void eat();
}

class Cat extends Animal{

    @Override
    public void eat() { //如果类不加修饰符，则访问访问是同包的类可访问
        System.out.println("吃鱼");
    }

    public void catchMouse(){
        System.out.println("抓老鼠");
    }
}

class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("吃骨头");
    }

    public void watchHouse(){
        System.out.println("看家");
    }
}

public class ClassCast {
    public static void main(String[] args) {
        Animal a = new Cat(); //向上转型
        a.eat();

        //Cat c = (Cat)a; //向下转型
        //c.catchMouse();

        //Dog d = (Dog)a; //向下转型 抛出ClassCastException
        //d.eat();

        /*
         当试图将对象强制转换为不是实例的子类时，抛出该异常；
　　      上面的测试类中创建了Cat类型对象，运行时不能转换成Dog对象的，这两个类型并没有任何继承关系，不符合类型转换的定义 ，因此会抛出ClassCastException异常；
         */

        if(a instanceof Cat){ //instanceof给引用变量做类型校验
            Cat c = (Cat) a;
            c.catchMouse();
        }else if(a instanceof Dog){
            Dog d = (Dog) a;
            d.watchHouse();
        }
    }
}
