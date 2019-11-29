package com.example.dokuku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_coba.*
import kotlinx.android.synthetic.main.fragment_detail.*

//1
class DetailFragment : Fragment() {
    private val cobaFragment = CobaFragment()

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        card_detail.setOnClickListener {
            btnSwitch()
        }
    }

    fun btnSwitch(){
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.cuma_fragment, cobaFragment)
        fragmentTransaction?.commit()
    }

}
//private val cobaFragment = CobaFragment()

//        card_detail.setOnClickListener {
//            val fragmentTransaction = fragmentManager?.beginTransaction()
//            fragmentTransaction?.replace(R.id.cuma_fragment, cobaFragment)
//            fragmentTransaction?.commit()
//        }

