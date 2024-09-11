package com.yang.basic.exception;

public class Runtime {
    public static void main(String[] args){
        int a = 1, b = 0;
        int c = 0;
        try {
            c = a / b;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(c);
    }
}
