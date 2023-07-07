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
        System.out.println();

        //Comparator lambda ex
        Comparator<Soldier> comparator = (s1, s2) -> s1.getRank().ordinal() - s2.getRank().ordinal(); //Önce rütbeye göre sırala
        comparator = comparator.thenComparing((s1, s2) -> s1.getFullName().compareTo(s2.getFullName())); //ardından rütbeye göre aynı olanları isme göre sırala

        soldiers.add(new Soldier(Rank.SUBAY, "Hakkı"));
        soldiers.add(new Soldier(Rank.UZMAN_CAVUS, "Alparslan"));

        System.out.println("******************************");
        Collections.sort(soldiers, comparator);
        soldiers.stream().forEach(s -> System.out.print(s.getFullName() + "-"));


    }
}
