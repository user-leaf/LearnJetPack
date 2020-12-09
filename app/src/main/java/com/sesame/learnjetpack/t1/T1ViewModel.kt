package com.sesame.learnjetpack.t1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/*ViewModel被设计以感知生命周期的方式，存储和管理与UI相关的数据*/
class T1ViewModel : ViewModel() {
    // LiveData是一个抽象类，不能直接使用。MutableLiveData是LiveData的一个最简单的实现。
    var nameLiveData = MutableLiveData<String>()
    var ageLiveData = MutableLiveData<Int>()
    private var studentLiveData = MutableLiveData<Student>()// 包含数据类型的

    var stuNameLiveData: LiveData<String> = Transformations.map(studentLiveData) {
        "${it.firstName} ${it.lastName}"
    }

    init {
        nameLiveData.value = "JetPack"
        ageLiveData.value = 0
        studentLiveData.value = Student("Michael", "Kan", 18, "98")
    }

    fun plusOne() {
        val temp = ageLiveData.value ?: 0
        ageLiveData.value = temp + 1
    }

    fun changeText() {
        nameLiveData.value = "JetPack:" + ageLiveData.value
    }

    fun clear() {
        ageLiveData.value = 0
    }


}