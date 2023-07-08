package com.ahmeterdogan.collections.set.treeset;

import com.ahmeterdogan.collections.set.hashset.User;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExamples {
    public static void main(String[] args) {
        /*
        TreeSet elemanlarını sıralı bir şekilde tutar bu yüzden geçilen nesnelerin ya Comparable olması gereklidir
        ya da TreeSet'e sıralamayı nasıl yapacağına dair dışarıdan Comparator vermemiz gerekir

        Senaryomuzda sıralama önemli değilse her zaman HashSet kullanmalıyız çünkü HashSet'in temel fonksiyonları
        (add, remove, contains) O(1)'e yakın performansla çalışırken. TreeSet'inkiler o(logn) ile çalışır
         */

        TreeSet<Integer> treeSet = getTreeSetWithRandomNumbers(10);
        listSet(treeSet);
        System.out.println(treeSet.first());//ilk eleman
        System.out.println(treeSet.last());//son eleman
        System.out.println(treeSet.higher(treeSet.first()));//verilen parametredeki elemandan bir sonraki eleman
        System.out.println(treeSet.lower(treeSet.last()));//verilen parametredki elemandan bir önceki eleman
        System.out.println(treeSet.lower(treeSet.first()));//ilk elemandan bir öncekini istedik null verdi
        treeSet.pollFirst(); //baştaki elemanı çıkarıyor last hali de var
        listSet(treeSet);
        System.out.println(treeSet.ceiling(10));//10'dan büyük ilk elemanı dönüyor
        System.out.println(treeSet.floor(10));//10'dan küçük ilk elemanı dönüyor


        System.out.println();
        TreeSet treeSet1 = new TreeSet();
        User user1 = new User(1, "Ahmet");
        User user2 = new User(2, "Sevval");
        User user3 = new User(1, "Mehmet");
        User user4 = new User(3, "Ali");
        User user5 = new User(4, "Zeynel");

        System.out.println(treeSet1.add(user1));
        System.out.println(treeSet1.add(user2));
        System.out.println(treeSet1.add(user3)); //CompareTo metoduna bakıyor aynılık kontrolü için
        System.out.println(treeSet1.add(user4));
        System.out.println(treeSet1.add(user5));
    }

    private static TreeSet<Integer> getTreeSetWithRandomNumbers(int num) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < num; i++) {
            int val = new Random().nextInt(100) + 1;
            if (!treeSet.add(val)) //Aynı elemandan eklemeye çalışırsak add metodu false dönüyor
                System.out.println("Duplicate element detected -> " + val);
        }

        return  treeSet;
    }

    private static void listSet(Set set) {
        set.forEach(i -> System.out.printf("%d - ", i));
        System.out.println();
    }
}
