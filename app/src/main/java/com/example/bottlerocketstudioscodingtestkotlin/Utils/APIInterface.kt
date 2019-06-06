package com.example.bottlerocketstudioscodingtestkotlin.Utils

import com.example.bottlerocketstudioscodingtestkotlin.Model.StoreList

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @get:GET("stores.json")
    val content: Call<StoreList>
}
