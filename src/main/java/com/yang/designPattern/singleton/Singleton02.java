package com.yang.designPattern.singleton;

public class Singleton02 {
    private static Singleton02 INSTANCE;

    static {
        INSTANCE = new Singleton02();
    }

    private Singleton02(){}

    public static Singleton02 getInstance(){return INSTANCE;}

    public static void main(String[] args) {
        Singleton02 singleton021 = Singleton02.getInstance();
        Singleton02 singleton022 = Singleton02.getInstance();
        System.out.println(singleton021 == singleton022);
    }
}

/*
2.饿汉式（静态代码块）【可用】
这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优缺点和上面是一样的。
 */
