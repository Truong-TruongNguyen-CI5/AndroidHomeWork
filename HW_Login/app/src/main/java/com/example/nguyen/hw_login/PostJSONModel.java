package com.example.nguyen.hw_login;

/**
 * Created by Nguyen on 10/25/2016.
 */
public class PostJSONModel {
    private String username;
    private String password;

    public PostJSONModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
