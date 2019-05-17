package com.example.bottlerocketstudioscodingtest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StoreList {
    @SerializedName("stores")
    private ArrayList<Store> storeList;

    public ArrayList<Store> getContentArrayList() {
        return storeList;
    }

    public void setContentArrayList(ArrayList<Store> storeList) {
        this.storeList = storeList;
    }
}
