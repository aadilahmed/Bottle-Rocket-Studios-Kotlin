package com.example.bottlerocketstudioscodingtestkotlin.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.bottlerocketstudioscodingtestkotlin.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.detail_activity_label)
        setContentView(R.layout.activity_detail)

        if (savedInstanceState == null) {
            val storeDetails = DetailFragment()

            val bundle = intent.extras
            storeDetails.arguments = bundle

            supportFragmentManager.beginTransaction()
                    .add(R.id.detail_fragment, storeDetails)
                    .commit()
        }
    }
}
