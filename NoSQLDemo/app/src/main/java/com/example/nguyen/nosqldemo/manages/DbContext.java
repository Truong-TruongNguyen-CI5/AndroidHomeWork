package com.example.nguyen.nosqldemo.manages;

import android.content.Context;

import com.example.nguyen.nosqldemo.models.Dog;
import com.example.nguyen.nosqldemo.models.Person;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Nguyen on 11/2/2016.
 */

public class DbContext {
    public Realm realm;

    public DbContext(Context context){
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

    private static DbContext instance;

    public static DbContext getInstance(){
        return instance;
    }

    public static void init(Context context){
        if(instance == null)
        instance = new DbContext(context);
    }

    private void deleteAllPerson (Class<? extends RealmObject> clazz){
        Realm realm = Realm.getDefaultInstance();
        realm.delete(clazz);
        realm.commitTransaction();
    }

    public boolean delete(Person person){
        if  (person == null) return  false;

        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        person.deleteFromRealm();
        realm.commitTransaction();
        return true;
    }

    public void  update(Person person, String name, int age){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        person.setName(name);
        person.setAge(age);
        realm.commitTransaction();
    }

    public void add(Person p){
        // getRealm
        Realm realm = Realm.getDefaultInstance();
        //Add object to Realm
        realm.beginTransaction();
        realm.copyToRealm(p);
        realm.commitTransaction();
    }
    private List<Person> findAllPerson(){
        //2 get Real default
        Realm realm = Realm.getDefaultInstance();

        //4
        RealmResults<Person> persons = realm
                .where(Person.class)
                .findAll();
        return  persons;
    }
        public Person findPersonByName(String name){
        Realm realm = Realm.getDefaultInstance();
        //3 Query  - laza load
        Person person = realm
                .where(Person.class)
                .equalTo("name", name, Case.INSENSITIVE)
                .findFirst();
        return  person;

    }

    public void addDogToPerson(Person person, Dog dog){
        realm.beginTransaction();
        person.getDogs().add(dog);
        realm.commitTransaction();
    }
     public int getNextId(Class<? extends RealmModel> clasz, String idKey){
        return  realm.where(clasz).max(idKey).intValue() + 1;
    }



    /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/



    public void add(Dog dog){
        realm.beginTransaction();
        realm.copyToRealm(dog);
        realm.beginTransaction();
    }
}
