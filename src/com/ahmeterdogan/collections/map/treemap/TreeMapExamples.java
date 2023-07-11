package com.ahmeterdogan.collections.map.treemap;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapExamples {
    public static void main(String[] args) {
        //Temel fonksiyonları put, remove, contains, get O(logn) karmaşaya sahiptir
        TreeMap<Integer, User> userMap = getUserMap();
        userMap.forEach((id, user) -> System.out.println(id + "--> " + user.getName()));
        System.out.println();
        System.out.println(userMap.ceilingEntry(4).getValue().getName());
        System.out.println(userMap.floorEntry(2).getValue().getName());
        System.out.println();

        System.out.println(userMap.firstEntry().getValue().getName());
        userMap.descendingMap().forEach((id, user) -> System.out.println(id + "--> " + user.getName()));

        System.out.println();
        userMap.pollFirstEntry(); //remove
        userMap.pollLastEntry(); //remove
        userMap.forEach((id, user) -> System.out.println(id + "--> " + user.getName()));

        TreeMap<Integer, User> mapWithComp = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return  o2 - o1;
            }
        });

        System.out.println();
        userMap = getUserMap();
        mapWithComp.putAll(userMap);
        mapWithComp.forEach((id, user) -> System.out.println(id + "--> " + user.getName()));
        System.out.println();
        userMap.headMap(5).forEach((id, user) -> System.out.println(id + "--> " + user.getName()));
        System.out.println();
        userMap.tailMap(5).forEach((id, user) -> System.out.println(id + "--> " + user.getName()));

    }

    private static TreeMap<Integer, User> getUserMap() {
        User user1 = new User(1, "ahmet",26);
        User user2 = new User(3, "şevval",25);
        User user3 = new User(5, "yusuf",22);
        User user4 = new User(7, "ayşe",33);
        User user5 = new User(8, "kaya",33);

        TreeMap<Integer, User> users = new TreeMap<>();
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);
        users.put(user4.getId(), user4);
        users.put(user5.getId(), user5);

        return users;
    }
}
