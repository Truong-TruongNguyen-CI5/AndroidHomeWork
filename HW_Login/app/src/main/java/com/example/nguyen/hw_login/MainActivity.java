package com.example.nguyen.hw_login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString() ;

    JSonModels jSonModels;
    EditText edtUsername;
    EditText edtPassword;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btLogin = (Button) findViewById(R.id.bt_login);
        addListeners();
    }

    private void addListeners() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPOSTRequest();
            }
        });
    }

    private void sendPOSTRequest() {

        OkHttpClient client = new OkHttpClient();

        PostJSONModel postJSONModel = new PostJSONModel(edtUsername.getText().toString(),edtPassword.getText().toString());

        final String jsonBody = (new Gson().toJson(postJSONModel));

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);

        Request request = new Request.Builder().url("https://a5-tumblelog.herokuapp.com/api/login").post(requestBody).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, String.format("onFailure:%s", e));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                jSonModels = new Gson().fromJson(body, JSonModels.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (jSonModels.getCode().toString().equals("1")) {
                            Log.d(TAG, "OK");
                            Toast.makeText(MainActivity.this, "Login Passed", Toast.LENGTH_LONG).show();
                        }
                        if (jSonModels.getCode().toString().equals("0")) {
                            Log.d(TAG, "FAILED");
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

        });
    }
}
