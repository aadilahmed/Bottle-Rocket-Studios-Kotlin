package com.example.bottlerocketstudioscodingtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bottlerocketstudioscodingtest.Model.Store;
import com.example.bottlerocketstudioscodingtest.Model.StoreList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class StoresFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemDecoration mDividerItemDecoration;
    private Retrofit retrofit;

    public StoresFragment () {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_stores, container,
                false);

        retrofit = RetrofitClientInstance.getRetrofitInstance();
        final APIInterface apiInterface = retrofit.create(APIInterface.class);

        Call<StoreList> call = apiInterface.getContent();

        call.enqueue(new Callback<StoreList>() {
            @Override
            public void onResponse(Call<StoreList> call, Response<StoreList> response) {
                if(!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(),
                            getResources().getString(R.string.network_error_message),
                            Toast.LENGTH_SHORT);
                    toast.show();
                }

                ArrayList<Store> storeList = response.body().getContentArrayList();

                mRecyclerView = rootView.findViewById(R.id.rv_stores_list);
                mRecyclerView.setHasFixedSize(true);
                mAdapter = new StoreAdapter(storeList);
                mLayoutManager = new LinearLayoutManager(getContext());
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);

                mDividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                        DividerItemDecoration.VERTICAL);
                mRecyclerView.addItemDecoration(mDividerItemDecoration);
            }

            @Override
            public void onFailure(Call<StoreList> call, Throwable t) {
            }
        });

        return rootView;
    }
}
