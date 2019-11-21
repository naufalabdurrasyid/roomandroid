package com.example.dokuku

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.AsyncTask
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.detail_layout.*
import kotlinx.android.synthetic.main.pengeluaran_layout.*
import kotlinx.android.synthetic.main.tambah_layout.*
import kotlinx.android.synthetic.main.tambah_layout.view.*

class PengeluaranActivity : AppCompatActivity() {
    var pengeluaranDatabase: PengeluaranDatabase? = null
    //    val compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambah_layout)

        pengeluaranDatabase = PengeluaranDatabase.getInstance(this)
//        getAllData(pengeluaran)
//        btn_tambah = (Button) findViewById(R.id.btn_tambah)
//        btn_upload.setOnClickListener {
//
//            val intent = Intent()
//                .setType("*/*")
//                .setAction(Intent.ACTION_GET_CONTENT)
//
//            startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)
//
//        }
        btn_simpandata.setOnClickListener {

            val tambahData = Pengeluaran(nama_barang.text.toString(), harga.text.toString().toInt())
            InsertTask(this, tambahData).execute()
            val intent = Intent(this, DetailPengeluaran::class.java)
            startActivity(intent)
        }

    }

    private class InsertTask(var context: PengeluaranActivity, var pengeluaran: Pengeluaran) :
        AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.pengeluaranDatabase!!.pengeluaranDao().insert(pengeluaran)
            return true
        }

    }
}