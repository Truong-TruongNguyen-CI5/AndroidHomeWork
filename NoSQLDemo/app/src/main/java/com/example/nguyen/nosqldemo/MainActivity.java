package com.example.nguyen.nosqldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.nguyen.nosqldemo.jsonmodels.Repo;
import com.example.nguyen.nosqldemo.manages.DbContext;
import com.example.nguyen.nosqldemo.models.Dog;
import com.example.nguyen.nosqldemo.models.Person;
import com.example.nguyen.nosqldemo.network.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString() ;
    private DbContext dbContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit gitHubRetrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GithubService githubService = gitHubRetrofit.create(GithubService.class);
        githubService
                .listRepos("qhuydtvt")
                .enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        Log.d(TAG, "onRespone");
                        List<Repo> repoList = response.body();
                        for(Repo repo : repoList){
                            Log.d(TAG, repo.toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        Log.d(TAG, "onFailure" + t.toString());
                    }
                });


    }


}
