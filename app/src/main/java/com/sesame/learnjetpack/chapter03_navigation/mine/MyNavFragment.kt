package com.sesame.learnjetpack.chapter03_navigation.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.sesame.learnjetpack.R
import com.sesame.learnjetpack.model.Person
import kotlinx.android.synthetic.main.fragment_my_nav.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyNavFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyNavFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_my_nav, container, false)
//        inflate.btnNext.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_myNavFragment_to_myNav2Fragment)
//        }

        // 错的，应该是小括号??
//        inflate.btnNext.setOnClickListener {
//            Navigation.createNavigateOnClickListener(R.id.action_myNavFragment_to_myNav2Fragment)
//        }

//        inflate.btnNext.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_myNavFragment_to_myNav2Fragment))

        inflate.btnNext.setOnClickListener {
            val person = Person("xx", 18)
            val bundle = Bundle()
            bundle.putSerializable("bundle", person)
            Navigation.findNavController(it).navigate(R.id.action_myNavFragment_to_myNav2Fragment, bundle)
        }

        val bundle = arguments
        if (bundle != null) {
            println("page1 bundle::" + bundle.getString("params"))
        }

        return inflate
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyNavFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MyNavFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}