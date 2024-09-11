package com.yang.basic.oop.array;

import java.util.Arrays;

/**
 * 一维数组常见操作
 */
public class arrayDefinition1 {
    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 100;

        /*
        遍历数组的三种方法如下
         */
        System.out.println(Arrays.toString(a));

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();



        // 数组静态初始化
        int[] b = new int[] {1, 3, 5, 7, 9};

        int[] c = b; // 数组引用传递
        c[0] = 100;
        System.out.println("array b is " + Arrays.toString(b));



        // 数组类型必须指向具体的实例化对象后才能操作具体元素
        int[] d = null;
        try {
            System.out.println(d[0]);
        } catch (NullPointerException e) {
            //throw new RuntimeException(e);
        } finally {
            System.out.println("是一个空指针");
        }
        System.out.println("结束话题");

        System.out.println(Math.pow(1.023, 5));
    }
}
