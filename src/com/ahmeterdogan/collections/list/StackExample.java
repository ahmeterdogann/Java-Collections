package com.ahmeterdogan.collections.list;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.add("one");
        stack.add("two");
        stack.add("three");
        stack.add("four");

        stack.forEach(System.out::println);
        System.out.println();
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println();
        stack.forEach(System.out::println);
    }
}
