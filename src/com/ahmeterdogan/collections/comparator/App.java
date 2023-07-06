package com.ahmeterdogan.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();

        soldiers.add(new Soldier(Rank.ASTSUBAY, "Eyüp"));
        soldiers.add(new Soldier(Rank.UZMAN_CAVUS, "Omer"));
        soldiers.add(new Soldier(Rank.UZMAN_CAVUS, "Hasan"));
        soldiers.add(new Soldier(Rank.SUBAY, "Gökhan"));
        soldiers.add(new Soldier(Rank.UZMAN_CAVUS, "Sadik"));
        soldiers.add(new Soldier(Rank.ASTSUBAY, "Burak"));
        soldiers.add(new Soldier(Rank.SUBAY, "Mert"));
        soldiers.add(new Soldier(Rank.SUBAY, "Batuhan"));

        soldiers.stream().forEach(s -> System.out.print(s.getFullName() + "-"));
        System.out.println();
        System.out.println("******************************");

        /* Diyelimki sınıfımız third party bir sınıf yada source koduna erişemediğimiz bir sınıf
           bu sınıfı Comparable interface'i ile implement edemediğimiz senaryoda Comparator sınıfını
           kullanacağız
         */

        //Comparator kullanarak rütbeye göre sıralama
        Collections.sort(soldiers, new Comparator<Soldier>() {
            @Override
            public int compare(Soldier o1, Soldier o2) {
                return o1.getRank().ordinal() - o2.getRank().ordinal();
            }
        });

        soldiers.stream().forEach(s -> System.out.print(s.getFullName() + "-"));

        //Comparator kullanarak alfabetik sıralama yaptık
        Collections.sort(soldiers, new Comparator<Soldier>() {
            @Override
            public int compare(Soldier o1, Soldier o2) {
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });

        System.out.println();
        System.out.println("******************************");
        soldiers.stream().forEach(s -> System.out.print(s.getFullName() + "-"));
    }
}
