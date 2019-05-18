package com.example.bottlerocketstudioscodingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            StoresFragment storeList = new StoresFragment();

            /*Bundle bundle = getIntent().getExtras();
            bundle.putBoolean("mTwoPane", mTwoPane);
            masterList.setArguments(bundle);*/

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.store_list_fragment, storeList)
                    .commit();
        }
    }
}