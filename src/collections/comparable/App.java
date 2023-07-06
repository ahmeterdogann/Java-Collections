package collections.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();

        soldiers.add(new Soldier(Rank.ASTSUBAY, "Eyüp"));
        soldiers.add(new Soldier(Rank.UZMAN_CAVUS, "Ömer"));
        soldiers.add(new Soldier(Rank.UZMAN_CAVUS, "Hasan"));
        soldiers.add(new Soldier(Rank.SUBAY, "Gökhan"));
        soldiers.add(new Soldier(Rank.UZMAN_CAVUS, "Sadık"));
        soldiers.add(new Soldier(Rank.ASTSUBAY, "Burak"));
        soldiers.add(new Soldier(Rank.SUBAY, "Mert"));
        soldiers.add(new Soldier(Rank.SUBAY, "Batuhan"));

        soldiers.stream().forEach(s -> System.out.print(s.getFullName() + "-"));
        System.out.println();
        System.out.println("******************************");
        Collections.sort(soldiers); //soldiers sınıfı Comparable interfaceini implement edip compareTo metodunu override ettiği için buraya parametre olarak geçebildik
        soldiers.stream().forEach(s -> System.out.print(s.getFullName() + "-"));
    }
}
