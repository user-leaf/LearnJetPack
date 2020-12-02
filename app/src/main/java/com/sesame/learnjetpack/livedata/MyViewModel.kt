package com.sesame.learnjetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }

    fun plusOne() {
        var count = counter.value ?: 0  // 不记得了怎么用
        counter.value = ++count
    }

    fun clear() {
        counter.value = 0
    }
}