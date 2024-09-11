package com.yang.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 创建对象的5种方式
 * https://blog.csdn.net/lsw333521/article/details/121925041
 * https://www.cnblogs.com/wxd0108/p/5685817.html
 * 1.new关键字 调用了构造函数
 * 2.Class类的newInstance方法创建对象 反射
 * 3.Constructor类的newInstance方法创建对象 反射
 * 4.使用clone方法
 * 5.使用反序列化创建对象
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
class TestClone implements Cloneable{
    private int id;
    private String name;

    @java.lang.Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CreateObject {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException {
        //1.new关键字创建对象
        DefaultUser user1 = new DefaultUser();
        user1.setId(1);
        user1.setName("张三");

        System.out.println(user1);

        //2.Class类的newInstance方法创建对象 反射
        DefaultUser user2 = (DefaultUser) Class.forName("com.yang.basic.DefaultUser").newInstance();
        /*
        newInstance和new的区别：
        （1）new是一个关键字，newInstance是一个方法
        （2）new实例化对象不需要加载类，new实例化对象是一步完成的
            newInstance需要先加载类，然后通过获得的类实例化对象，将实例化分成了两步
        （3）new关键字实例化对象可以调用任意的构造函数，而newInstance实例化对象只能调用类的无参构造函数
         */
        user2.setId(2);
        user2.setName("李四");
        System.out.println(user2);

        //3.Constructor类的newInstance方法
        Constructor cons = DefaultUser.class.getConstructor();
        DefaultUser user3 = (DefaultUser) cons.newInstance();
        user3.setId(3);
        user3.setName("李五");
        System.out.println(user3);

        //2和3的区别见https://www.programmingmitra.com/2016/05/creating-objects-through-reflection-in-java-with-example.html

        //4.使用clone方法 clone()是Object类的方法，但是想要使用必须实现Cloneable接口，clone()方法只会浅复制，并且不需要调用构造函数
        TestClone t1 = new TestClone(4, "T4");
        TestClone t2 = (TestClone) t1.clone();
        System.out.println(t2);



        //5.使用反序列化创建对象
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(user3);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        DefaultUser user4 = (DefaultUser) in.readObject();
        in.close();
        user4.setId(34);
        System.out.println(user4);
    }
}
