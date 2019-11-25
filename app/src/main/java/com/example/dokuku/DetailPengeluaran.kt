package com.example.dokuku

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Bitmap.createScaledBitmap
import android.os.AsyncTask
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.detail_layout.*
import kotlinx.android.synthetic.main.pengeluaran_layout.*

class DetailPengeluaran : AppCompatActivity() {
    var pengeluaranDatabase: PengeluaranDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        pengeluaranDatabase = PengeluaranDatabase.getInstance(this)
        btn_display.setOnClickListener {
            GetPengeluaranData(this).execute()
        }
        tv_item_name.setText(intent.getStringExtra("nama")?:"")
//        item_foto.setImageResource(intent.getIntExtra("foto", 0))
        item_foto.setImageBitmap(intent.getParcelableExtra("foto"))
//        Glide.with(this)
//            .load(item_foto.setImageResource(intent.getIntExtra("foto", 0)))





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

