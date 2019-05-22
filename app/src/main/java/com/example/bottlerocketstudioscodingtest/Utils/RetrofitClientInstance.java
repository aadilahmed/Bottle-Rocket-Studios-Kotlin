package com.example.bottlerocketstudioscodingtest.Utils;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL =
            "http://sandbox.bottlerocketapps.com/BR_Android_CodingExam_2015_Server/";

    public static Retrofit getRetrofitInstance(Context context) {
        int cacheSize = (5 * 1024 * 1024);
        Cache mCache = new Cache(context.getCacheDir(), cacheSize);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(mCache)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}