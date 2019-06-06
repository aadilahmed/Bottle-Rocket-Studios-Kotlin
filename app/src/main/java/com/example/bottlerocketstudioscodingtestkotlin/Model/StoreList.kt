package com.example.bottlerocketstudioscodingtestkotlin.Model

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class StoreList {
    @SerializedName("stores")
    var contentArrayList: ArrayList<Store>? = null
}
