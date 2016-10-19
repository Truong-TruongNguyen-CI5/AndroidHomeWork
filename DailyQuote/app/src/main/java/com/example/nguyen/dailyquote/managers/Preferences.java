package com.example.nguyen.dailyquote.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nguyen on 10/12/2016.
 */

public class Preferences {

    private static final String KEY = "Quote" ;
    private static final String USER_NAME_KEY = "Username" ;
    private SharedPreferences sharedPreferences;
    public Preferences(Context context){
        //Context can be activity  or app
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }
    public String getUsername(){
        return sharedPreferences.getString(USER_NAME_KEY, null);
    }
    public void putUsername(String userName){
        sharedPreferences
                .edit()
                .putString(USER_NAME_KEY, userName)
                .commit();
    }
    private  static Preferences instance;

    public static Preferences getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new Preferences(context);
    }

}
