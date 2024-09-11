package com.yang.basic;

public class Hashcode {
    public static void main(String[] args) {
        String s1 = "Aa";
        String s2 = "BB";
        System.out.println(String.format("s1:%d | s2:%d", s1.hashCode(), s2.hashCode()));
        System.out.println(s1.equals(s2));
    }
}
