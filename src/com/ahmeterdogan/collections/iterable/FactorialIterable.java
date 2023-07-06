package com.ahmeterdogan.collections.iterable;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class FactorialIterable implements Iterable<Integer> {
    private int value;
    public FactorialIterable(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int a = 0;
            @Override
            public boolean hasNext() {
                return value >= a;
            }

            @Override
            public Integer next() {
                a++;
                return getFactorial(a);
            }
        };
    }

    private int getFactorial(int val) {
        if (val == 0)
            return 1;

        int fac = 1;

        for (int i = 2; i <= val; i++) {
            fac *= i;
        }

        return fac;
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
