package com.example.bottlerocketstudioscodingtestkotlin.UI

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.bottlerocketstudioscodingtestkotlin.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val storeList = StoresFragment()

            supportFragmentManager.beginTransaction()
                    .add(R.id.store_list_fragment, storeList)
                    .commit()
        }
    }
}