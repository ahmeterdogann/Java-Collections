package com.ahmeterdogan.collections.set.hashset;

import java.util.*;
import java.util.stream.Collectors;

public class HashSetExamples {
    public static void main(String[] args) {
        /*
        Doluluk oranı 0.75 ulaşınca hashset'i otomatik olarak belli bir formüle göre büyütüyor. Bu performans sorunlarına
        neden olabiliyor. Kaç eleman gireceği belli olacağı zaman direkt diğer ctorları kullanarak o kapasiteye sahip
        hashset yaratabiliriz. 0.75 değerini 0.9 vs.'de yapabiliriz.
         */
        Set<Integer> set = getHashSetWithRandomNumbers(10);

        listSet(set);

        //set.forEach(s -> set.removeIf(integer -> integer % 2 == 0)); //ConcurrentModificationException aldık bunu araştıracam
        //set içerisindeki çift rakamlarım setten çıkarılması
        new HashSet<>(set).forEach(s -> set.removeIf(integer -> integer % 2 == 0)); //yukardaki problemin çözüm - 1
        set.stream().collect(Collectors.toSet()).forEach(s -> set.removeIf(integer -> integer % 2 == 0)); //yukardaki problemin çözüm - 2

        listSet(set);

        System.out.println("***************************************************");

        HashSet<Integer> set1 = new HashSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);
        listSet(set1);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        set1.retainAll(list);//retainAll metodu ile parametrede verdiğimiz collection'da bulunan nesneler saklanır geri kalan set'ten remove edilir
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        set1.removeAll(list1);//removeAll metodu ile parametrede verdiğimiz collection'da bulunan nesneler set'ten remove edilir
        listSet(set1);

        System.out.println("***************************************************");

        Set setOf = Set.of(1, 2, 3 ,4);
        //Set setOf = Set.of(1, null, 3 ,4); //NullPointerEx verir of metotları oluşturulan set'e null eklenemez
        listSet(setOf);
        //setOf.add(1); Set'i of metotları ile oluşturduğumuz için unmodifiable oldu ve add işleminde exception verdi.

        System.out.println("***************************************************");

        HashSet<Integer> set2 = new HashSet();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        listSet(set2);
        System.out.println(set2.contains(1));
        System.out.println(set2.isEmpty());
        System.out.println(set2.size());

        System.out.println("***************************************************");
        /*Peki set'in add metodu set'te bulunan bir nesne eklemeye çalıştığımız nasıl false dönüyor
          eklenmeye çalışan nesne ile içerdeki nesneler arasında önce hashCode metotlarından dönen değere
          bakıyor dönen sonuçlar aynı ise equals metodunu çağırıyor burdan da true dönerse nesnelerin aynı olduğu
          sonucuna varıp elemanı set'e eklemeyip false dönüyor. Aşağıda kendi yazdığım User sınıfında örnekler vardır.
         */
        User user1 = new User(1, "Ahmet");
        User user2 = new User(2, "Sevval");
        User user3 = new User(1, "Mehmet");
        User user4 = new User(3, "Ali");

        HashSet<User> userSet = new HashSet<>();
        System.out.println(userSet.add(user1));//sadece hashcode'a baktı farklı değer döndü direkt ekleme yaptı equals bakmadı
        System.out.println(userSet.add(user2));//sadece hashcode' baktı farklı değer döndü direkt ekleme yaptı equals bakmadı
        System.out.println(userSet.add(user3));//ilk önce hashcode'a aynı değer dönünde equals() metoduna da baktı burdan da true dönünde false döndürdü
        System.out.println(userSet.add(user4));//sadece hashcode'a baktı farklı değer döndü direkt ekleme yaptı equals bakmadı

        System.out.println("***************************************************");




    }

    private static void listSet(Set set) {
        set.forEach(i -> System.out.printf("%d - ", i));
        System.out.println();
    }

    private static HashSet<Integer> getHashSetWithRandomNumbers (int num) {
        HashSet<Integer> hashSet = new HashSet();

        for (int i = 0; i < num; i++) {
            int val = new Random().nextInt(100) + 1;
            if (!hashSet.add(val)) //Aynı elemandan eklemeye çalışırsak add metodu false dönüyor
                System.out.println("Duplicate element detected -> " + val);
        }

        return  hashSet;
    }
}
