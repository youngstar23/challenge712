package com.yang.basic.collection;

import java.util.ArrayList;
import java.util.HashSet;

public class ArrayListStudyCont1 {
    private static final int SIZE = 100_000;
    public static void main(String[] args) {
        /*ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
        arr2.add(5);

        arr1.addAll(1, arr2);
        System.out.println(arr1);
        System.out.println(arr2);*/

        /*HashSet<String> set = new HashSet<>();
        set.add("张三");
        set.add("李四");
        set.add("王五");
        System.out.println(set);

        set.add("张三");

        ArrayList<String> arr = new ArrayList<>();
        arr.addAll(set);
        System.out.println("arr is "+arr);*/

        /*ArrayList<String> arr = new ArrayList<>();

        arr.add("张三");
        arr.add("李四");
        arr.add("王五");
        System.out.println(arr);

        arr.add("张三");

        HashSet<String> set = new HashSet<>();
        set.addAll(arr);
        System.out.println("set is "+set);

        set.removeAll(set);
        System.out.println(set);*/

        /*//Java ArrayList clear vs removeAll
        //https://blog.csdn.net/pigcircle_1988/article/details/84911197
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            arr1.add(i);
            arr2.add(i);
        }

        long startTime = System.nanoTime();
        arr1.removeAll(arr1);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        arr2.clear();
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);*/

        ArrayList<String> sites = new ArrayList<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        ArrayList<String> cloneSites = (ArrayList<String>) sites.clone();
        System.out.println(cloneSites);

        //cloneSites.add("JD");
        sites.add("JD");
        System.out.println("After clone: "+cloneSites);
        System.out.println(sites);
    }
}
