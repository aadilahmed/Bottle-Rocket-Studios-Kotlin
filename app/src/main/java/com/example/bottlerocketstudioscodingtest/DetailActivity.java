package com.example.bottlerocketstudioscodingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            DetailFragment storeDetails = new DetailFragment();

            Bundle bundle = getIntent().getExtras();
            //bundle.putBoolean("mTwoPane", mTwoPane);
            storeDetails.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_fragment, storeDetails)
                    .commit();
        }
    }
}
