package com.sesame.learnjetpack.t1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sesame.learnjetpack.R
import kotlinx.android.synthetic.main.activity_t1.*

class T1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_t1)

        val viewModel = ViewModelProvider(this).get(T1ViewModel::class.java)

        viewModel.nameLiveData.observe(this, Observer { value -> tvShow.setText(value) })
        viewModel.ageLiveData.observe(this, Observer { value -> tvShow.setText("$value") })

        plusOneBtn.setOnClickListener {
            viewModel.plusOne()
        }

        changeTextBtn.setOnClickListener {
            viewModel.changeText()
        }

        clearBtn.setOnClickListener {
            viewModel.clear()
        }

//        viewModel.studentLiveData.observe(this, Observer { stu ->
//            tvShow.text = stu.toString()
//        })

        viewModel.stuNameLiveData.observe(this, Observer { stuName ->
            tvShow.text = stuName
        })
    }
}