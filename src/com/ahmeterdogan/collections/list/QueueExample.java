package com.ahmeterdogan.collections.list;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();

        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");

        queue.forEach(System.out::println);
        System.out.println();
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println();
        queue.forEach(System.out::println);
    }
}
