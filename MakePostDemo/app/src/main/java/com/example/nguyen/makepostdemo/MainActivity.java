package com.example.nguyen.makepostdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =  MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postData();
    }

    private void postData() {
        OkHttpClient client = new OkHttpClient();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");


        RequestBody body = RequestBody.create(JSON, new Gson().toJson(new Item("34314653", "google.vn", "NULL")));

        final Request request = new Request.Builder()
                .url("http://jsonplaceholder.typicode.com/posts")
                .post(body)
                .addHeader("Authorization", "header value")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.d("response ", "onResponse(): " + response.body().string());
            }
        });


//        FormBody formBody = new FormBody.Builder().add("key", "value")
//                .build();
//
//        Request request = new Request.Builder()
//                .url("http://jsonplaceholder.typicode.com/posts")
//                .post(formBody).build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String bodyString = response.body().string();
//                Log.d(TAG, String.format("Body string: %s", bodyString));
//            }
//        });
   }
}
