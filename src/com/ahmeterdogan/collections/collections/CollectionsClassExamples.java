package com.ahmeterdogan.collections.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsClassExamples {
    public static void main(String[] args) {
        Collections.synchronizedList(new ArrayList<>()); //Multi-thread ortamlarda vector hashtable kullanmak yerine Collections sınıfını kullan

        List<Integer> randomNumber = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            randomNumber.add(new Random().nextInt(100));

        randomNumber.forEach(System.out::println);
        System.out.println();
        Collections.shuffle(randomNumber); //Collections sınıfında shuffle metodu gibi birçok utility method vardır.
        randomNumber.forEach(System.out::println);

        System.out.println("*****************************");
        //Akın hoca kursundaki örnekler
        List list = new ArrayList(20);
        for(int i = 0; i < 20; i++){
            list.add(i);
        }

        System.out.println("List before shuffle is " + list);
        System.out.println();
        Collections.shuffle(list);
        System.out.println("Shuffled list is " + list);
        System.out.println();
        Collections.reverse(list);
        System.out.println("Reversed list: " + list);
        System.out.println();
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
        System.out.println();
        Collections.swap(list, 0, 19);
        System.out.println("Swapped list: " + list);
        System.out.println();
        Collections.sort(list);
        System.out.println("Sorted list: " + list);
        System.out.println();
        System.out.println(Collections.binarySearch(list, -9));
        System.out.println();
        Collections.rotate(list, 3);
        System.out.println("Rotated list: " + list);
    }
}
