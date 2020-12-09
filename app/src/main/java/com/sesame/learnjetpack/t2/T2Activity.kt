package com.sesame.learnjetpack.t2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sesame.learnjetpack.R
import kotlinx.android.synthetic.main.activity_t2.*

/**
 * 重温、回顾。ViewModel/LiveData/MVVM
 */
class T2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t2)

        val viewModel = ViewModelProvider(this).get(T2ViewModel::class.java)

//        viewModel.userLiveData.observe(this, Observer { value ->
//            tvShow.text = value.firstName
//        })

        viewModel.userNameLiveData.observe(this, Observer { value ->
            tvShow.text = value
        })

        button.setOnClickListener {
            viewModel.change()
        }
    }
}
