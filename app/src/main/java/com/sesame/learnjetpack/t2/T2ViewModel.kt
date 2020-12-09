package com.sesame.learnjetpack.t2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class T2ViewModel : ViewModel() {

    var user = User("b", "kan", 20)

    private var userLiveData = MutableLiveData<User>()

    init {
        userLiveData.value = user
    }


    val userNameLiveData = Transformations.map(userLiveData) { user ->
        "${user.firstName}.${user.lastName}"
    }


    fun change() {
        // 这样写没有用 why 没有setValue()和postValue()，所以没有触发。
//        userLiveData.value!!.firstName = "a"
//        userLiveData.value!!.age = 22
        // 这样写没起作用 同上
        user.firstName = "aaa"
        user.age = (0..100).random()
        //
//        userLiveData.value = User("aaa", "bbb", 222)


    }
}