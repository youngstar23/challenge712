package com.yang.basic.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListStudy {
    public static void main(String[] args) {
        //add添加元素
        ArrayList<String> arr = new ArrayList<>();
        arr.add("张三");
        arr.add("李四");
        arr.add("王五");
        System.out.println(arr);

        //get(index) 访问元素，通过index访问数组中具体位置
        System.out.println(arr.get(2));

        //set(index, value) 修改元素，前者是下标索引，后者是要修改的值
        arr.set(2, "钱六");
        System.out.println(arr);

        //remove(index) 删除索引为index的元素
        arr.remove(1);
        System.out.println(arr);
        //remove(object) 删除object对象
        arr.remove("钱六");
        System.out.println(arr);

        ArrayList<String> srr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            srr.add(i + "个");
        }
        for (int i = 4; i >= 0; i--) {
            srr.add(i + "个");
        }
        System.out.println(srr);
        srr.remove("2个"); //删除的是找到的一个元素，后面若还有相同的元素，不删除
        System.out.println(srr);

        //size() 获取集合的大小
        System.out.println(arr.size());

        /*
        ArrayList遍历的三种方式
        1.循环遍历 for循环遍历
        2.随机访问，通过索引值去遍历
        3.Iterator，迭代访问
         */
        srr = new ArrayList<>();
        srr.add("诗");
        srr.add("书");
        srr.add("礼");
        srr.add("乐");
        for (String s : srr) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int i = 0; i < srr.size(); i++) {
            System.out.print(srr.get(i) + " ");
        }
        System.out.println();
        Iterator<String> iter = srr.iterator();
        while (iter.hasNext()) {
            String value = iter.next();
            System.out.print(value + " ");
        }
        System.out.println();

        //Collections.sort()对字符或者数字列表进行排序
        srr = new ArrayList<>();
        srr.add("Taobao");
        srr.add("Wiki");
        srr.add("Runoob");
        srr.add("Weibo");
        srr.add("Google");
        srr.add("apple"); //这里之所以用小写的原因是验证排序的规则---字典序排序
        Collections.sort(srr);
        System.out.println(srr);

        ArrayList<Integer> drr = new ArrayList<>();

    }
}

//https://www.runoob.com/java
