package com.sesame.learnjetpack

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.sesame.learnjetpack.chapter02_lifecycle.application.ApplicationObserver

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }
}