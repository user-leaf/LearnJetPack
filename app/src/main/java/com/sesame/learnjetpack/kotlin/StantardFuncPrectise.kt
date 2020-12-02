package com.sesame.learnjetpack.kotlin

import android.content.Context
import android.content.Intent
import com.sesame.learnjetpack.MainActivity

fun main() {
    val list = mutableListOf<String>("aaa", "bbb", "ccc", "ddd")
    withFunc(list)
    println()
    runFunc(list)
    println()
}

fun applyFunc(context: Context) {
    val intent = Intent(context, MainActivity::class.java).apply {
        putExtra("name", "kanbin")
        putExtra("age", 18)
    }
    context.startActivity(intent)
}

fun runFunc(list: MutableList<String>) {
    val result = StringBuilder().run {
        append("run!\n")
        for (item in list) {
            append(item).append("\n")
        }
        append("over!")
        toString()
    }
    println(result)
}

fun withFunc(list: List<String>) {
    val result = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (item in list) {
            append(item).append("\n")
        }
        append("End.")
        toString()
    }
    println(result)

}