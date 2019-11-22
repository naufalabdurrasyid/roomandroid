package com.example.dokuku

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_pengeluaran.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity





class CardViewPengeluaran(val listPengeluaran: ArrayList<Data>) : RecyclerView.Adapter<CardViewPengeluaran.CardViewViewHolder>() {

//    private lateinit var onItemClickCallback: CardViewPengeluaran.OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: CardViewPengeluaran.OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
        var onItemClick: ((View) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_pengeluaran, parent, false)
        return CardViewViewHolder(view)

    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {

        val pengeluaran = listPengeluaran[position]
        Glide.with(holder.itemView.context)
            .load(pengeluaran.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = pengeluaran.name
        holder.btnDetail.setOnClickListener(onItemClick)
//        holder.tvDetail.text = pengeluaran.detail
//        holder.itemView.setOnClickListener { Toast.makeText(holder.itemView.context, "Kamu memilih " + listPengeluaran[holder.adapterPosition].name, Toast.LENGTH_SHORT).show() }
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + listPengeluaran[position].name, Toast.LENGTH_SHORT).show()
//        }
//
//        holder.btnDetail.setOnClickListener {
//            context.startActivity(Intent(context, DetailPengeluaran::class.java))

//            val intent = Intent(this, DetailPengeluaran::class.java)
//
//            startActivity(intent)
//        }
        holder.btnDetail.setOnClickListener(View.OnClickListener { v ->
            val intent = Intent(v.context, DetailPengeluaran::class.java)
            intent.putExtra("nama", holder.tvName.text.toString())
            v.context.startActivity(intent)
        })

    }
    override fun getItemCount(): Int {
        return listPengeluaran.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        var imgPhoto: ImageView = itemView.findViewById(R.id.item_foto)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        //        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
//        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnDetail: Button = itemView.findViewById(R.id.btn_detail)
//        init {
//            itemView.setOnClickListener {
//                onItemClick?.invoke(this, DetailPengeluaran::class.java)
//            }
//        }
    }

    }



//    interface OnItemClickCallback {
//        fun onItemClicked()
//    }

//    fun onSelectedItem(){
//
//    }

