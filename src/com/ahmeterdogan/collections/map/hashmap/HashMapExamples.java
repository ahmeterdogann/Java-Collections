package com.ahmeterdogan.collections.map.hashmap;

import java.util.*;

public class HashMapExamples {
    public static void main(String[] args) {
        //Temel fonksiyonları (put, remove, contains, get) O(1)
        //HashCode değerini nesnelere hızlı ulaşmak için kullanır, put metodunda key'in hash'ini put yapar anahtarlar tekildir ve get ile anahtar geçildiğinde önce hash hesaplar sonra değere ulaşır O(1)
        Map<String, Integer> map = getHashMap();
        System.out.println(map.put("one", 2));//1
        System.out.println(map.put("one", 3));//2 değiştirilen elemanı dönüyor
        System.out.println();

        map = getHashMap();
        System.out.println(map.get("one"));
        System.out.println();

        map.forEach((k,v) -> System.out.printf("%s --> %d%n", k, v)); //sıralı vermez
        System.out.println();

        System.out.println(map.getOrDefault("six", -1)); //yoksa default get et
        System.out.println();

        map.compute("one", (k, v) -> k.length() * v); //bifunction ile key value arasında hesaplama yapıp value'ye setler
        System.out.println(map.get("one"));
        map.computeIfAbsent("six", k -> 6); //verilen key yoksa ya da değeri null ise
        System.out.println(map.get("six"));
        map.computeIfPresent("seven", (k, v) -> k.length() * v);
        System.out.println(map.get("seven"));//null döner çünkü computeİfPresent dedik
        map.computeIfPresent("six", (k, v) -> k.length() * v);
        System.out.println(map.get("six"));//18
        System.out.println();

        map = getHashMap();
        Set<String> keySet = map.keySet();
        keySet.forEach(System.out::println);
        System.out.println();
        Collection<Integer> values = map.values();
        values.forEach(System.out::println);
        System.out.println();

        System.out.println(map.replace("one", 2, 2));//one'ın oldValue değeri 2 olmadığı için replace başarısız
        System.out.println(map.replace("one", 2)); //değiştirilen değeri döner -> 1

        System.out.println(map.get("eleven"));//null döner çünkü eleven diye bir key yok. dikkat eleven diye bir key var olup değeri null olsa yine null dönecekti

        map = getHashMap();
        map.remove("one");
        System.out.println();

        Map<String, String> mapStr = new HashMap<>();
        mapStr.put("KEY","VALUE");
        System.out.println(mapStr.merge("KEY", " + ANOTHER_STRING", String::concat));



    }

    private static Map<String, Integer> getHashMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1); //map' eleman eklemeye yarar eklenen elemanı geri döner
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        return map;
    }

    private static <K,V> void listMap(Map<K,V> map) {
        map.forEach((k,v) -> System.out.printf("%s --> %d%n", k, v));
    }
}
