package com.example.nguyen.nosqldemo.models;

import io.realm.RealmObject;

/**
 * Created by Nguyen on 11/2/2016.
 */

public class Dog extends RealmObject {

    String breed;
    String name;

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static Dog create(String breed , String name){
        Dog dog = new Dog();
        dog.setBreed(breed);
        dog.setName(name);
        return  dog;
    }
}
