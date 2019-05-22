package com.example.bottlerocketstudioscodingtest.UI;

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
import com.example.bottlerocketstudioscodingtest.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailFragment extends Fragment implements OnMapReadyCallback {
    private String address;
    private String city;
    private String name;
    private String phone;
    private String state;
    private String zipcode;
    private String latitude;
    private String longitude;

    private MapView mMapView;
    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";

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
        phone = store.getPhone();
        state = store.getState();
        zipcode = store.getZipcode();
        latitude = store.getLatitude();
        longitude = store.getLongtitude();

        final String phone_digits_only = phone.replaceAll("\\D", "");

        TextView store_name = rootView.findViewById(R.id.detail_store_name);
        TextView store_address = rootView.findViewById(R.id.detail_store_address);
        TextView store_phone = rootView.findViewById(R.id.detail_store_phone);

        store_name.setText(name);
        store_address.setText(address);
        store_address.append(", " + city + ", " + state + " " + zipcode);
        store_phone.setText(phone);

        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }
        mMapView = rootView.findViewById(R.id.location_map);
        mMapView.onCreate(mapViewBundle);

        mMapView.getMapAsync(this);

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

        CardView get_directions_frame = rootView.findViewById(R.id.get_directions_frame);
        get_directions_frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + latitude + "," + longitude);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY);
        if (mapViewBundle == null) {
            mapViewBundle = new Bundle();
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle);
        }

        mMapView.onSaveInstanceState(mapViewBundle);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng loc = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        map.addMarker(new MarkerOptions().position(loc).title(name));
        map.moveCamera(CameraUpdateFactory.newLatLng(loc));
        map.setMinZoomPreference(15);
    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
