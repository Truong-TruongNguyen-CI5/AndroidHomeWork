package com.example.nguyen.hw_login;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString() ;

    JSonModelsRespone jSonModelsRespone;
    EditText edtUsername;
    EditText edtPassword;
    Button btLogin;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    private void login() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://a5-tumblelog.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        // Create Models - request
        JSONModelRequest JSONModelRequest = new JSONModelRequest(edtUsername.getText().toString(),edtPassword.getText().toString());

        final String jsonBody = (new Gson().toJson(JSONModelRequest));

        final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),jsonBody);

        retrofit2.Call<JSonModelsRespone> response = service.login("login", requestBody);

        response.enqueue(new retrofit2.Callback<JSonModelsRespone>() {
            @Override
            public void onResponse(retrofit2.Call<JSonModelsRespone> call, retrofit2.Response<JSonModelsRespone> response) {
                final JSonModelsRespone responeResult = response.body();
                //Log.d(TAG, String.format("onRespone: %s", response.body().toString()));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (responeResult.getCode().toString().equals("1")) {
                            Log.d(TAG, "OK");
                            Toast.makeText(MainActivity.this, "Login Passed", Toast.LENGTH_LONG).show();
                        }
                        if (responeResult.getCode().toString().equals("0")) {
                            Log.d(TAG, "FAILED");
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

            @Override
            public void onFailure(retrofit2.Call<JSonModelsRespone> call, Throwable t) {

            }
        });

    }

    private void addListeners() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                //sendPOSTRequest();
                login();
            }
        });
    }

    private void sendPOSTRequest() {

        OkHttpClient client = new OkHttpClient();

        JSONModelRequest JSONModelRequest = new JSONModelRequest(edtUsername.getText().toString(),edtPassword.getText().toString());

        final String jsonBody = (new Gson().toJson(JSONModelRequest));

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
                jSonModelsRespone = new Gson().fromJson(body, JSonModelsRespone.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (jSonModelsRespone.getCode().toString().equals("1")) {
                            Log.d(TAG, "OK");
                            Toast.makeText(MainActivity.this, "Login Passed", Toast.LENGTH_LONG).show();
                        }
                        if (jSonModelsRespone.getCode().toString().equals("0")) {
                            Log.d(TAG, "FAILED");
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

        });
    }
}
