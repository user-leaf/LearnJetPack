package com.sesame.learnjetpack.chapter02_lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.learnjetpack.R
import com.sesame.learnjetpack.chapter02_lifecycle.activity.MyLocationListener
import com.sesame.learnjetpack.chapter02_lifecycle.activity.OnLocationChangedCallback
import com.sesame.learnjetpack.chapter02_lifecycle.service.MyService
import kotlinx.android.synthetic.main.activity_my_lifecycle.*

class MyLifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_lifecycle)

        val myLocationListener = MyLocationListener(this, object : OnLocationChangedCallback {
            override fun onChange(name: String, age: Int) {

            }

        })

        lifecycle.addObserver(myLocationListener)

        btnStart.setOnClickListener {
            startService(Intent(this, MyService::class.java))
        }

        btnStop.setOnClickListener {
            stopService(Intent(this, MyService::class.java))
        }
    }
}