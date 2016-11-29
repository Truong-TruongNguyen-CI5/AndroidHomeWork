package com.example.nguyen.playermusic;


import android.content.Context;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Nguyen on 11/28/2016.
 */

public class DBRealm {

    public Realm realm;
    public static DBRealm instance;

    public DBRealm(Context context){
        RealmConfiguration config = new RealmConfiguration.Builder(context).build();

        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
    }

    public static void init(Context context){
        if(instance == null){
            instance = new DBRealm(context);
        }
    }

    public static DBRealm getInstance() {
        return instance;
    }

    public void addItemAlbum(ItemAlbum ita){
        // getRealm
        Realm realm = Realm.getDefaultInstance();
        //Add object to Realm
        realm.beginTransaction();
        realm.copyToRealm(ita);
        realm.commitTransaction();
    }

    public List<ItemAlbum> getAllItemAlbum(){
        //2 get Real default
        Realm realm = Realm.getDefaultInstance();

        //4
        RealmResults<ItemAlbum> persons = realm
                .where(ItemAlbum.class)
                .findAll();
        return  persons;
    }

    public void  addList(List<ItemAlbum> albumList){
        //delete old
        deleteAllItem(ItemAlbum.class);

        //update
        Realm realm = Realm.getDefaultInstance();
        for (ItemAlbum ita : albumList) {
            //Add object to Realm
            realm.beginTransaction();
            realm.copyToRealm(ita);
            realm.commitTransaction();
        }
    }

    private void deleteAllItem (Class<? extends RealmObject> clazz){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(clazz);
        realm.commitTransaction();
    }
}
