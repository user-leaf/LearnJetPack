package com.sesame.learnjetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var counter = MutableLiveData<Int>()
    var num = MutableLiveData<Int>()

    init {
        counter.value = 0
        num.value = 0
    }

    /*个人觉得：所需要的变量都定义在这儿了，所以对这些数据的处理，写在这儿比较好*/
    fun plusOne() {
        var count = counter.value ?: 0  // 不记得了怎么用
        counter.value = ++count
    }

    fun clear() {
        counter.value = 0
    }
}
