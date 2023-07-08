package com.ahmeterdogan.collections.set.hashset;

public class User implements Comparable {
    private int id;
    private String fullName;

    public User(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        return this.id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        return this.id - user.getId();
    }
}
