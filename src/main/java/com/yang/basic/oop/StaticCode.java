package com.yang.basic.oop;

class Book{
    private String title;
    private static int num;
    public Book(String title){
        this.title = title;
        ++num;
        System.out.println("这是入库的第"+num+"本图书，该图书是《"+title+"》。");
    }
}
public class StaticCode {
    public static void main(String[] args) {
        new Book("Java");
        new Book("MySQL");
        new Book("Algorithm");
    }
}
