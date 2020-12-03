package com.sesame.learnjetpack.t1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*ViewModel被设计以感知生命周期的方式，存储和管理与UI相关的数据*/
class T1ViewModel : ViewModel() {
    // LiveData是一个抽象类，不能直接使用。MutableLiveData是LiveData的一个最简单的实现。
    var name = MutableLiveData<String>()
    var age = MutableLiveData<Int>()

    init {
        name.value = "JetPack"
        age.value = 0
    }

    fun plusOne() {
        val temp = age.value ?: 0
        age.value = temp + 1
    }

    fun changeText(){
        name.value = "JetPack:" + age.value
    }

    fun clear() {
        age.value = 0
    }

}