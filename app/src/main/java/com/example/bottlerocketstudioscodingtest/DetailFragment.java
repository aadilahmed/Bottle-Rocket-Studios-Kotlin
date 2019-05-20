package com.example.bottlerocketstudioscodingtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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
    private String zipcode;

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
        zipcode = store.getZipcode();

        final String phone_digits_only = phone.replaceAll("\\D", "");

        TextView store_name = rootView.findViewById(R.id.detail_store_name);
        TextView store_address = rootView.findViewById(R.id.detail_store_address);
        TextView store_phone = rootView.findViewById(R.id.detail_store_phone);

        store_name.setText(name);
        store_address.setText(address);
        store_address.append(", " + city + ", " + state + " " + zipcode);
        store_phone.setText(phone);

        CardView phone_frame = rootView.findViewById(R.id.number_frame);
        phone_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone_digits_only));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
