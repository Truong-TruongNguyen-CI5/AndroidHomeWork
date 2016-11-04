package com.example.nguyen.nosqldemo.network;

import com.example.nguyen.nosqldemo.jsonmodels.Repo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Nguyen on 11/2/2016.
 */

public interface GithubService  {
    @GET("users/{usn}/repos")
    Call<List<Repo>> listRepos (@Path("usn") String username);
}
