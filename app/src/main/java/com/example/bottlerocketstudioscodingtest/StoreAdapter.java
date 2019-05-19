package com.example.bottlerocketstudioscodingtest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bottlerocketstudioscodingtest.Model.Store;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Store> stores;

    public StoreAdapter(ArrayList<Store> stores) {
        this.stores = stores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View storeItem = LayoutInflater.from(context)
                .inflate(R.layout.store_item, viewGroup, false);
        return new StoreAdapter.ViewHolder(storeItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Store store = stores.get(i);

        String logo = store.getStoreLogoURL();
        String number = store.getPhone();
        String address = store.getAddress();
        String name = store.getName();

        viewHolder.mStorePhoneNumberView.setText(number);
        viewHolder.mStoreAddressView.setText(address);
        viewHolder.mStoreNameView.setText(name);

        Glide.with(context).load(logo).into(viewHolder.mImageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("store", store);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mStoreAddressView;
        private TextView mStorePhoneNumberView;
        private TextView mStoreNameView;
        private ImageView mImageView;
        private CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mStoreAddressView = itemView.findViewById(R.id.store_address);
            mStorePhoneNumberView = itemView.findViewById(R.id.store_phone);
            mStoreNameView = itemView.findViewById(R.id.store_name);
            mImageView = itemView.findViewById(R.id.store_logo);
        }
    }
}
