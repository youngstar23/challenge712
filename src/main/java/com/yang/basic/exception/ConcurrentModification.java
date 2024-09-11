package com.yang.basic.exception;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModification {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer value = iterator.next();
            if(value == 2){
                list.remove(value);
            }
        }
    }
}

/*
modCount和expectedModCount是用于表示修改次数的，
其中modCount表示集合的修改次数，这其中包括了调用集合本身的add方法等修改方法时进行的修改和调用集合迭代器的修改方法进行的修改。
而expectedModCount则是表示迭代器对集合进行修改的次数。

Java ConcurrentModificationException异常原因和解决方法
https://baijiahao.baidu.com/s?id=1713785647833025453&wfr=spider&for=pc

单线程用iterator.remove()移除元素
多线程在iterator迭代的时候使用synchronized或者lock进行同步/使用并发容器CopyOnWriteArrayList代替ArrayList和Vector
 */
