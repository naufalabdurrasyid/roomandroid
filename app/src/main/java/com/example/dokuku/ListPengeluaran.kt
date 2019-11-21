package com.example.dokuku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_pengeluaran.*
import kotlinx.android.synthetic.main.pengeluaran_layout.*

class ListPengeluaran : AppCompatActivity() {
    private lateinit var rv_pengeluaran: RecyclerView
    private var list: ArrayList<Data> = arrayListOf()
    val cardViewPengeluaran = CardViewPengeluaran(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pengeluaran_layout)
        rv_pengeluaran = findViewById(R.id.rv_pengeluaran)
        rv_pengeluaran.setHasFixedSize(true)
        list.addAll(PengeluaranData.dataPengeluaran)
        showRecyclerCardView()

        btn_tambah.setOnClickListener {
            val intent = Intent(this, PengeluaranActivity::class.java)
            startActivity(intent)
        }
        btn_profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
//        cardViewPengeluaran.onItemClick = {
//                btn_detail.setOnClickListener {
//                    val intent = Intent(this, DetailPengeluaran::class.java)
//                    startActivity(intent)
//                }
//
//            }
        }
    private fun showRecyclerCardView() {
        rv_pengeluaran.layoutManager = LinearLayoutManager(this)
        val cardViewPengeluaran = CardViewPengeluaran(list)
        rv_pengeluaran.adapter = cardViewPengeluaran

    }
    }



//    fun showDetail() {
//         card_view.setOnClickListener {
//            val intent = Intent(this, DetailPengeluaran::class.java)
//            startActivity(intent)
//        }
//    }



//
//    private fun showPengeluaran(data: Data) {
//        Toast.makeText(this, "Kamu memilih " + data.name, Toast.LENGTH_SHORT).show()
//
//    }
//    private fun showDetail(intent: Intent){
//
//    }




