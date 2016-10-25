package com.example.nguyen.hw_login;

/**
 * Created by Nguyen on 10/25/2016.
 */

public class JSonModels {
    private String code;
    private String message;

    public JSonModels(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
