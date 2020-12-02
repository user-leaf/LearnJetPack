package com.sesame.learnjetpack

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sesame.learnjetpack.viewmodel.MainViewModel
import com.sesame.learnjetpack.viewmodel.MainViewModel2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var viewModel2: MainViewModel2
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(MyObserver())

//        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(this.application))
//                .get(MainViewModel::class.java)

        // APP退出仍可以恢复数据（就只是利用sp+传参给model）
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)

        viewModel2 = ViewModelProvider(this, MainViewModelFactory(countReserved))
                .get(MainViewModel2::class.java)

        plusOneBtn.setOnClickListener {
//            viewModel.count++
            viewModel2.count++
            refreshCounter()
        }

        clear.setOnClickListener {
            viewModel2.count = 0
            refreshCounter()
        }

        refreshCounter()
    }

    private fun refreshCounter() {
//        tv.text = viewModel.count.toString()
        tv.text = viewModel2.count.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit().putInt("count_reserved", viewModel2.count).apply()
    }
}
