package com.example.dokuku

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_layout.*

class DetailPengeluaran : AppCompatActivity() {
    var pengeluaranDatabase: PengeluaranDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        pengeluaranDatabase = PengeluaranDatabase.getInstance(this)
        btn_display.setOnClickListener {
            GetPengeluaranData(this).execute()
        }
    }

    private class GetPengeluaranData(var context: DetailPengeluaran) :
        AsyncTask<Void, Void, List<Pengeluaran>>() {
        override fun doInBackground(vararg params: Void?): List<Pengeluaran> {
            return context.pengeluaranDatabase!!.pengeluaranDao().getAll()
        }

        override fun onPostExecute(pengeluaranList: List<Pengeluaran>?) {
            if (pengeluaranList!!.size > 0) {
                for (i in 0..pengeluaranList.size - 1) {
                    context.dataResult.append(pengeluaranList[i].nama_barang)
                    context.dataResult.append(pengeluaranList[i].harga.toString())


                }
            }
        }
    }
}