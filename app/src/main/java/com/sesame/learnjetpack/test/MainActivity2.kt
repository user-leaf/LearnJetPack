package com.sesame.learnjetpack.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sesame.learnjetpack.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 测试。旋转屏幕，页面内数据丢失。
 */
class MainActivity2 : AppCompatActivity() {

    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plusOneBtn.setOnClickListener {
            count++
            refresh()
        }

        refresh()
    }

    private fun refresh() {
        tv.text = count.toString()
    }
}