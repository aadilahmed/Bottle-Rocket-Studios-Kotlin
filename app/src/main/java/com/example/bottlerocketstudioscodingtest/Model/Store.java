package com.example.bottlerocketstudioscodingtest.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Store implements Parcelable {
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
    @SerializedName("zipcode")
    private String zipcode;

    public Store(String address, String city, String name, String storeLogoURL, String phone,
                 String state, String zipcode){
        this.address = address;
        this.city = city;
        this.name = name;
        this.storeLogoURL = storeLogoURL;
        this.phone = phone;
        this.state = state;
        this.zipcode = zipcode;
    }

    protected Store(Parcel in) {
        address = in.readString();
        city = in.readString();
        name = in.readString();
        storeLogoURL = in.readString();
        phone = in.readString();
        state = in.readString();
        zipcode = in.readString();
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(address);
        parcel.writeString(city);
        parcel.writeString(name);
        parcel.writeString(storeLogoURL);
        parcel.writeString(phone);
        parcel.writeString(state);
        parcel.writeString(zipcode);
    }
}
