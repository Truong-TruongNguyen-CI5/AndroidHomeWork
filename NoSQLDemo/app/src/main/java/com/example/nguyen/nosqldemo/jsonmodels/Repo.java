package com.example.nguyen.nosqldemo.jsonmodels;

/**
 * Created by Nguyen on 11/2/2016.
 */

public class Repo {
    private int id;
    private String name;
    private String full_name;

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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
