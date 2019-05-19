package com.example.bottlerocketstudioscodingtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bottlerocketstudioscodingtest.Model.Store;

public class DetailFragment extends Fragment {
    private String address;
    private String city;
    private String name;
    private String storeLogoURL;
    private String phone;
    private String state;

    public DetailFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_detail, container,
                false);

        Bundle bundle = getArguments();

        Store store = bundle.getParcelable("store");

        address = store.getAddress();
        city = store.getCity();
        name = store.getName();
        storeLogoURL = store.getStoreLogoURL();
        phone = store.getPhone();
        state = store.getState();

        TextView store_name = rootView.findViewById(R.id.detail_store_name);
        TextView store_address = rootView.findViewById(R.id.detail_store_address);
        TextView store_phone = rootView.findViewById(R.id.detail_store_phone);

        store_name.setText(name);
        store_address.setText(address);
        store_phone.setText(phone);

        return rootView;
    }
}
