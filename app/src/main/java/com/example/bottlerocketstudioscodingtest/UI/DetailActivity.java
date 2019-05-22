package com.example.bottlerocketstudioscodingtest.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bottlerocketstudioscodingtest.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.detail_activity_label);
        setContentView(R.layout.activity_detail);

        if (savedInstanceState == null) {
            DetailFragment storeDetails = new DetailFragment();

            Bundle bundle = getIntent().getExtras();
            storeDetails.setArguments(bundle);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_fragment, storeDetails)
                    .commit();
        }
    }
}
