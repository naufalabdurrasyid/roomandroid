package com.example.dokuku

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "pengeluaran")
data class Pengeluaran(@ColumnInfo(name = "nama_barang")var nama_barang: String,
                           @ColumnInfo(name = "harga")var harga: Int,
                           @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Long = 0)
