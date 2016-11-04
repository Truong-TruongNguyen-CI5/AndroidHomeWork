package com.example.nguyen.hw_login;

/**
 * Created by Nguyen on 10/25/2016.
 */
public class JSONModelRequest {
    private String username;
    private String password;

    public JSONModelRequest(String username, String password) {
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
