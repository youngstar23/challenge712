package com.yang.basic;

import org.openjdk.jol.info.ClassLayout;

/*public class Final {
    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder("hello");
        System.out.println("sb中的内容是"+sb);
        System.out.println(sb+"的哈希编码是"+sb.hashCode());
        sb.append(" 我对其进行修改");
        System.out.println("sb中的内容是"+sb);
        System.out.println(sb+"的哈希编码是"+sb.hashCode());
    }
}*/

public class Final{
     static class Person{
        private String name = "张三";

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }
    public static void main(String[] args) {
        final Person person = new Person();
        System.out.println(person.getName());
        person.setName("李四");
        System.out.println(person.getName());
    }
}
