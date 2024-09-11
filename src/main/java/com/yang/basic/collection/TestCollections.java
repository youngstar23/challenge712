package com.yang.basic.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollections {
    public static void main(String[] args) {
        List list = new ArrayList();
        double[] array = {112, 111, 23, 456, 231};
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
