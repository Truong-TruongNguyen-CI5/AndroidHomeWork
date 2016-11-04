package com.example.nguyen.hw_login;

/**
 * Created by Nguyen on 10/25/2016.
 */

public class JSonModelsRespone {

    private String code;
    private String message;

    public JSonModelsRespone(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message.toString();
    }
}
