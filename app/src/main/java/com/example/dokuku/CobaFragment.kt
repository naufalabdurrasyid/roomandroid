package com.example.dokuku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_coba.*

//1
class CobaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coba, container, false)
    }
}
//    private val detailFragment = DetailFragment()
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        card_coba.setOnClickListener {
//            btnSwitchBack()
//        }
//
//    }
//    fun btnSwitchBack(){
//        val fragmentTransaction = fragmentManager?.beginTransaction()
//        fragmentTransaction?.replace(R.id.cuma_fragment, detailFragment)
//        fragmentTransaction?.commit()
//    }

//        card_detail.setOnClickListener {
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.fragment_coba)
//            fragmentTransaction.commit()
//        }