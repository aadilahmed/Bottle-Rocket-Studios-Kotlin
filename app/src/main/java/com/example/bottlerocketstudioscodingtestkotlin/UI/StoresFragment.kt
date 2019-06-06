package com.example.bottlerocketstudioscodingtestkotlin.UI

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.bottlerocketstudioscodingtestkotlin.Model.StoreList
import com.example.bottlerocketstudioscodingtestkotlin.R
import com.example.bottlerocketstudioscodingtestkotlin.Utils.APIInterface
import com.example.bottlerocketstudioscodingtestkotlin.Utils.RetrofitClientInstance

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class StoresFragment : Fragment() {
    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var retrofit: Retrofit? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_stores, container,
                false)

        retrofit = RetrofitClientInstance.getRetrofitInstance(context!!)
        val apiInterface = retrofit!!.create(APIInterface::class.java)

        val call = apiInterface.content

        call.enqueue(object : Callback<StoreList> {
            override fun onResponse(call: Call<StoreList>, response: Response<StoreList>) {
                if (!response.isSuccessful) {
                    val toast = Toast.makeText(activity!!.applicationContext,
                            resources.getString(R.string.network_error_message),
                            Toast.LENGTH_SHORT)
                    toast.show()
                }

                val storeList = response.body()!!.contentArrayList
                mRecyclerView = rootView.findViewById(R.id.rv_stores_list)
                mRecyclerView!!.setHasFixedSize(true)
                mAdapter = StoreAdapter(storeList!!)
                mLayoutManager = LinearLayoutManager(context)
                mRecyclerView!!.layoutManager = mLayoutManager
                mRecyclerView!!.adapter = mAdapter
            }

            override fun onFailure(call: Call<StoreList>, t: Throwable) {
                Log.d(resources.getString(R.string.main_activity_tag), t.localizedMessage)
            }
        })

        return rootView
    }
}
