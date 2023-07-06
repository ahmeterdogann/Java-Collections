package com.ahmeterdogan.collections.iterable;

public class App {
    public static void main(String[] args) {
        FactorialIterable factorialIterable = new FactorialIterable(5);

        //Kendi iterable sınıfımızı yazdık. Iterable interface'ini implement ettiğimiz için for each deyimine sınıfın nesnesini verebildik
        for (Integer i : factorialIterable) {
            System.out.println(i);
        }
    }
}
