package com.sesame.learnjetpack.chapter03_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sesame.learnjetpack.R
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {

    private lateinit var userName: String
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            userName = MainFragmentArgs.fromBundle(bundle).userName
            age = MainFragmentArgs.fromBundle(bundle).age
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_second, container, false)
        inflate.tv.text = "username: $userName, age:$age"
        return inflate
    }
}