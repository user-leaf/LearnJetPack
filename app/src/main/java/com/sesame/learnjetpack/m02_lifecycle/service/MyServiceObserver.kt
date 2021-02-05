package com.sesame.learnjetpack.m02_lifecycle.service

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyServiceObserver : LifecycleObserver {
    private val TAG = MyServiceObserver::class.java.simpleName

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startGetLocation() {
        Log.d(TAG, "@@@startGetLocation: service")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stopGetLocation() {
        Log.d(TAG, "@@@stopGetLocation: service")
    }
}