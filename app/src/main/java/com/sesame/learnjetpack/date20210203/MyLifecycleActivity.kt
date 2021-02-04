package com.sesame.learnjetpack.date20210203

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.learnjetpack.R

class MyLifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_lifecycle)

        val myLocationListener = MyLocationListener(this, object : OnLocationChangedCallback {
            override fun onChange(name: String, age: Int) {

            }

        })

        lifecycle.addObserver(myLocationListener)
    }
}