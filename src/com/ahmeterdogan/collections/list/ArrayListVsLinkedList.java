package com.ahmeterdogan.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        int numberOfElements = 100_000;
        List<Integer> arraylist = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) {
            arraylist.add(0, i); //başa ekleme yaptığımız için arraylist çok yavaş çalıştı linkedlist'e göre
//            arraylist.add(i);
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < numberOfElements; i++) {
            linkedList.add(0, i);
//            linkedList.add(i);
        }
        long end2 = System.currentTimeMillis();

        System.out.println("ArrayList : " + (end1 - start1));
        System.out.println("LinkedList : " + (end2 - start2));
    }
}
