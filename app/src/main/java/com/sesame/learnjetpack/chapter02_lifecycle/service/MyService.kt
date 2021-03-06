package com.sesame.learnjetpack.chapter02_lifecycle.service

import androidx.lifecycle.LifecycleService

class MyService : LifecycleService() {

    init {
    }

    override fun onCreate() {
        super.onCreate()

        val myServiceObserver = MyServiceObserver()
        lifecycle.addObserver(myServiceObserver)
    }
}