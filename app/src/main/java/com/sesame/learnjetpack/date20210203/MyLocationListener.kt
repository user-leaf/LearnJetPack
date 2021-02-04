package com.sesame.learnjetpack.date20210203

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLocationListener(context: Context, val callback: OnLocationChangedCallback) : LifecycleObserver {

    val TAG = MyLocationListener::class.java.simpleName

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startLocation() {
        Log.d(TAG, "startLocation: ")
        callback.onChange("a", 1)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopLocation() {
        Log.d(TAG, "stopLocation: ")
        callback.onChange("b", 2)
    }

}
