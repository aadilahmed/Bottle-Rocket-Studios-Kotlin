package com.example.bottlerocketstudioscodingtest.Model;

import com.google.gson.annotations.SerializedName;

public class Store {
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("name")
    private String name;
    @SerializedName("storeLogoURL")
    private String storeLogoURL;
    @SerializedName("phone")
    private String phone;
    @SerializedName("state")
    private String state;

    public Store(String address, String city, String name, String storeLogoURL, String phone,
                 String state){
        this.address = address;
        this.city = city;
        this.name = name;
        this.storeLogoURL = storeLogoURL;
        this.phone = phone;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoreLogoURL() {
        return storeLogoURL;
    }

    public void setStoreLogoURL(String storeLogoURL) {
        this.storeLogoURL = storeLogoURL;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
