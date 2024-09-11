package com.yang.basic.oop;

class PersonProperties{
    private String name;
    private int age;
    private static String country = "中华民国";

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        PersonProperties.country = country;
    }

    public PersonProperties(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}

public class StaticProperties {
    private final static String s1 = "test1";

    public static void main(String[] args) {
        PersonProperties perA = new PersonProperties("张三", 10);
        PersonProperties perB = new PersonProperties("李四", 10);
        PersonProperties perC = new PersonProperties("王五", 10);
        PersonProperties.setCountry("改革开放以后，所有人民过上了幸福的生活！");
        System.out.println(perA);
        System.out.println(perB);
        System.out.println(perC);

        System.out.println(s1);
    }
}
