package com.sesame.learnjetpack.viewmodel

import androidx.lifecycle.ViewModel

/**
 * 传参
 */
class MainViewModel2(countReserved: Int): ViewModel() {
    var count = countReserved
}