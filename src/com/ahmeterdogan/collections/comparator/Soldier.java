package com.ahmeterdogan.collections.comparator;

public class Soldier{
    private Rank rank;
    private String fullName;

    public Soldier(Rank rank, String fullName) {
        this.rank = rank;
        this.fullName = fullName;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
