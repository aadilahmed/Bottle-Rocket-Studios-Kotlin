package com.example.bottlerocketstudioscodingtest.Utils;

import com.example.bottlerocketstudioscodingtest.Model.StoreList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("stores.json")
    Call<StoreList> getContent();
}
