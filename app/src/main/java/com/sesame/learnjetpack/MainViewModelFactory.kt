package com.sesame.learnjetpack

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sesame.learnjetpack.viewmodel.MainViewModel2

class MainViewModelFactory(private val countReserved: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel2(countReserved) as T
    }
}