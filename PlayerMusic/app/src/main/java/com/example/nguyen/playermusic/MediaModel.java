package com.example.nguyen.playermusic;

import java.util.ArrayList;

/**
 * Created by Nguyen on 11/26/2016.
 */

public class MediaModel {

    private String id;

    MediaModel(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Subgenre> subgenres;

    public ArrayList<Subgenre> getSubgenres() {
        return subgenres;
    }

    public void setSubgenres(ArrayList<Subgenre> subgenres) {
        this.subgenres = subgenres;
    }

    public class Subgenre{
        String id;
        String translation_key;

        public Subgenre(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTranslation_key() {
            return translation_key;
        }

        public void setTranslation_key(String translation_key) {
            this.translation_key = translation_key;
        }
    }


}
