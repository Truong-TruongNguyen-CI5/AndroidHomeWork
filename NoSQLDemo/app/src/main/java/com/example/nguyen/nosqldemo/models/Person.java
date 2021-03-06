package com.example.nguyen.nosqldemo.models;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Nguyen on 11/2/2016.
 */

public class Person extends RealmObject {
    private int id;
    private String name;
    private int age;
    private RealmList<Dog> dogs;

    public Person() {
        dogs = new RealmList<>();
    }

    public RealmList<Dog> getDogs() {
        return dogs;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dogs=" + dogs.size() +
                '}';
    }

    public static Person create(int id,String name, int age){
        Person p = new Person();
        p.id = id;
        p.name = name;
        p.age = age;
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
