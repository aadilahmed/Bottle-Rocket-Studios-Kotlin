package com.example.bottlerocketstudioscodingtestkotlin.UI

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.bottlerocketstudioscodingtestkotlin.Model.Store
import com.example.bottlerocketstudioscodingtestkotlin.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailFragment : Fragment(), OnMapReadyCallback {
    private var address: String? = null
    private var city: String? = null
    private var name: String? = null
    private var phone: String? = null
    private var state: String? = null
    private var zipcode: String? = null
    private var latitude: String? = null
    private var longitude: String? = null

    private var mMapView: MapView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container,
                false)

        val bundle = arguments

        val store = bundle!!.getParcelable<Store>("store")

        address = store!!.address
        city = store.city
        name = store.name
        phone = store.phone
        state = store.state
        zipcode = store.zipcode
        latitude = store.latitude
        longitude = store.longtitude

        val phone_digits_only = store.phone!!.replace("\\D".toRegex(), "")

        rootView.detail_store_name.text = name
        rootView.detail_store_address.text = address
        rootView.detail_store_address.append(", $city, $state $zipcode")
        rootView.detail_store_phone.text = phone

        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY)
        }
        mMapView = rootView.findViewById(R.id.location_map)
        mMapView!!.onCreate(mapViewBundle)

        mMapView!!.getMapAsync(this)

        rootView.number_frame.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phone_digits_only")
            if (intent.resolveActivity(activity!!.packageManager) != null) {
                startActivity(intent)
            }
        }

        rootView.get_directions_frame.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=$latitude,$longitude")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(activity!!.packageManager) != null) {
                startActivity(mapIntent)
            }
        }

        return rootView
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        var mapViewBundle = outState.getBundle(MAPVIEW_BUNDLE_KEY)
        if (mapViewBundle == null) {
            mapViewBundle = Bundle()
            outState.putBundle(MAPVIEW_BUNDLE_KEY, mapViewBundle)
        }

        mMapView!!.onSaveInstanceState(mapViewBundle)
    }

    override fun onResume() {
        super.onResume()
        mMapView!!.onResume()
    }

    override fun onStart() {
        super.onStart()
        mMapView!!.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMapView!!.onStop()
    }

    override fun onMapReady(map: GoogleMap) {
        val loc = LatLng(java.lang.Double.parseDouble(latitude!!), java.lang.Double.parseDouble(longitude!!))
        map.addMarker(MarkerOptions().position(loc).title(name))
        map.moveCamera(CameraUpdateFactory.newLatLng(loc))
        map.setMinZoomPreference(15f)
    }

    override fun onPause() {
        mMapView!!.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        mMapView!!.onDestroy()
        super.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView!!.onLowMemory()
    }

    companion object {
        private val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    }
}
