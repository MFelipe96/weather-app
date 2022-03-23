package com.example.base_feature.core

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Looper
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.viewbinding.ViewBinding
import com.example.base_feature.R
import com.google.android.gms.location.*


abstract class BaseLocation<Binding: ViewBinding>: BaseFragment<Binding>() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun setupView() {
        super.setupView()
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext())
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission()
        }
        displaysAlertIfRequired()
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                requestNewLocationData()
            } else {
                Toast.makeText(
                    context, getString(R.string.permission_denied_message),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkPermission(){
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) -> {
                locationListener()
            }
            else -> {
                requestPermissionLauncher.launch(
                    Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun locationListener(){
        fusedLocationProviderClient.lastLocation.addOnSuccessListener(requireActivity()) { location ->
            if (location != null) {
                val latitude = location.latitude
                val longitude = location.longitude
                getWeatherFromCurrentLocation(latitude, longitude)
            }
        }
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val mLastLocation: Location = locationResult.lastLocation
            val latitude = mLastLocation.latitude
            val longitude = mLastLocation.longitude
            getWeatherFromCurrentLocation(latitude, longitude)
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        val mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        fusedLocationProviderClient.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }

    private fun displaysAlertIfRequired(){
        if(!isLocationEnabled())
            Toast.makeText(
                context, getString(R.string.warning_message),
                Toast.LENGTH_LONG
            ).show()
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager: LocationManager = context?.getSystemService(LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    open fun getWeatherFromCurrentLocation(latitude: Double, longitude: Double) = Unit
}