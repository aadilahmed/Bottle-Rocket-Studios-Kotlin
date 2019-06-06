package com.example.bottlerocketstudioscodingtestkotlin.Model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class Store : Parcelable {
    @SerializedName("address")
    var address: String? = null
    @SerializedName("city")
    var city: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("storeLogoURL")
    var storeLogoURL: String? = null
    @SerializedName("phone")
    var phone: String? = null
    @SerializedName("state")
    var state: String? = null
    @SerializedName("zipcode")
    var zipcode: String? = null
    @SerializedName("latitude")
    var latitude: String? = null
    @SerializedName("longitude")
    var longtitude: String? = null
    @SerializedName("storeID")
    var storeID: String? = null

    constructor(address: String, city: String, name: String, storeLogoURL: String, phone: String,
                state: String, zipcode: String, latitude: String, longitude: String, storeID: String) {
        this.address = address
        this.city = city
        this.name = name
        this.storeLogoURL = storeLogoURL
        this.phone = phone
        this.state = state
        this.zipcode = zipcode
        this.latitude = latitude
        this.longtitude = longitude
        this.storeID = storeID
    }

    protected constructor(`in`: Parcel) {
        address = `in`.readString()
        city = `in`.readString()
        name = `in`.readString()
        storeLogoURL = `in`.readString()
        phone = `in`.readString()
        state = `in`.readString()
        zipcode = `in`.readString()
        latitude = `in`.readString()
        longtitude = `in`.readString()
        storeID = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(address)
        parcel.writeString(city)
        parcel.writeString(name)
        parcel.writeString(storeLogoURL)
        parcel.writeString(phone)
        parcel.writeString(state)
        parcel.writeString(zipcode)
        parcel.writeString(latitude)
        parcel.writeString(longtitude)
        parcel.writeString(storeID)
    }

    /*companion object {

        val CREATOR: Parcelable.Creator<Store> = object : Parcelable.Creator<Store> {
            override fun createFromParcel(`in`: Parcel): Store {
                return Store(`in`)
            }

            override fun newArray(size: Int): Array<Store> {
                return arrayOfNulls(size)
            }
        }
    }*/

    companion object CREATOR : Parcelable.Creator<Store> {
        override fun createFromParcel(parcel: Parcel): Store {
            return Store(parcel)
        }

        override fun newArray(size: Int): Array<Store?> {
            return arrayOfNulls(size)
        }
    }
}
