package com.sesame.learnjetpack.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sesame.learnjetpack.R
import kotlinx.android.synthetic.main.activity_main.*

class LiveDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 获取ViewModel
        val viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
                .get(MyViewModel::class.java)

        plusOneBtn.setOnClickListener {
            viewModel.plusOne()
        }

        clear.setOnClickListener {
            viewModel.clear()
        }

        viewModel.counter.observe(this, Observer {
            count -> tv.text = count.toString()
        })
    }
}