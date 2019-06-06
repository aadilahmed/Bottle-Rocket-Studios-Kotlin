package com.example.bottlerocketstudioscodingtestkotlin.UI

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bumptech.glide.Glide
import com.example.bottlerocketstudioscodingtestkotlin.Model.Store
import com.example.bottlerocketstudioscodingtestkotlin.R
import kotlinx.android.synthetic.main.store_item.view.*

import java.util.ArrayList

class StoreAdapter(private val stores: ArrayList<Store>) : RecyclerView.Adapter<StoreAdapter.ViewHolder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        context = viewGroup.context
        val storeItem = LayoutInflater.from(context)
                .inflate(R.layout.store_item, viewGroup, false)
        return ViewHolder(storeItem)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val store = stores[i]

        val logo = store.storeLogoURL
        val number = store.phone
        val address = store.address
        val name = store.name
        val city = store.city

        viewHolder.mStorePhoneNumberView.setText(R.string.phone_label)
        viewHolder.mStorePhoneNumberView.append(" $number")
        viewHolder.mStoreAddressView.text = address
        viewHolder.mStoreAddressView.append(", $city")
        viewHolder.mStoreNameView.text = name

        Glide.with(context!!).load(logo).into(viewHolder.mImageView)

        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("store", store)
            context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return stores.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mStoreAddressView = itemView.store_address
        val mStorePhoneNumberView = itemView.store_phone
        val mStoreNameView = itemView.store_name
        val mImageView = itemView.store_logo
    }
}
