package com.example.nguyen.playermusic;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Nguyen on 11/4/2016.
 */

public interface Service {
    @GET("/data/media-types.json")
    Call<List<MediaModel>> result();
}
