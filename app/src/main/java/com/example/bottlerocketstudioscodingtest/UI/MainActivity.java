package com.example.bottlerocketstudioscodingtest.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bottlerocketstudioscodingtest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            StoresFragment storeList = new StoresFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.store_list_fragment, storeList)
                    .commit();
        }
    }
}