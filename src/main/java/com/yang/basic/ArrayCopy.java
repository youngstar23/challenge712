package com.yang.basic;

public class ArrayCopy {
    static Integer[] a;
    public static void main(String[] args) {
        /*int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        int[] b = a;
        for (int i = 0; i < b.length; i++) {
            b[i] = (int) (Math.random() * 10);
        }
        for (int ele : a) {
            System.out.println(ele);
        }*/

        /*
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);

        //output is false 存放在堆中，每次都是新申请
        */

        /*String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);
        //output is true 存放在常量池中，先查找，找不到再申请

        Integer x = 10;
        Integer y = 10;
        System.out.println(x == y);
        System.out.println(x.equals(y));*/

        /*byte x = 127;
        byte y = 127;
        //x = (byte) (x + y);
        x += y;
        System.out.println(x);*/

        short s1 = 1;
        s1 = (short) (s1 + 1);
    }
}
