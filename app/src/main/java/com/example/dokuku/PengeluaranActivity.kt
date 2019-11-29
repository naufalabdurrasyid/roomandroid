package com.example.dokuku

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.AsyncTask
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.detail_layout.*
import kotlinx.android.synthetic.main.fragment_coba.*
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_pengeluaran.*
import kotlinx.android.synthetic.main.pengeluaran_layout.*
import kotlinx.android.synthetic.main.tambah_layout.*
import kotlinx.android.synthetic.main.tambah_layout.view.*

class PengeluaranActivity : AppCompatActivity() {
    var pengeluaranDatabase: PengeluaranDatabase? = null
    private val fragmentManager = supportFragmentManager

    private val detailFragment = DetailFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_layout)

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.cuma_fragment, detailFragment)
        fragmentTransaction.commit()

        pengeluaranDatabase = PengeluaranDatabase.getInstance(this)
        btn_simpandata.setOnClickListener {

            val tambahData = Pengeluaran(nama_barang.text.toString(), harga.text.toString().toInt())
            InsertTask(this, tambahData).execute()
            val intent = Intent(this, DetailPengeluaran::class.java)
            startActivity(intent)
        }

    }

    fun btnSwitchBack(v: View){
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.cuma_fragment, detailFragment)
        fragmentTransaction.commit()
    }

    private class InsertTask(var context: PengeluaranActivity, var pengeluaran: Pengeluaran) :
        AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.pengeluaranDatabase!!.pengeluaranDao().insert(pengeluaran)
            return true

        }

    }
}


//    fun btnSwitch(v: View){
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.cuma_fragment, cobaFragment)
//        fragmentTransaction.commitNow()
//    }
