package com.ahmeterdogan.collections.map.treemap;

public class User {
    private int id;
    private String name;
    private int yas;

    public User(int id, String name, int yas) {
        this.id = id;
        this.name = name;
        this.yas = yas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
