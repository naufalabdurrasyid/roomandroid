package com.example.dokuku

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
@Dao
interface PengeluaranDao {
    @Query("Select * from pengeluaran" )
    fun getAll(): List<Pengeluaran>

    @Insert(onConflict = REPLACE)
    fun insert(pengeluaran: Pengeluaran)

    @Delete
    fun delete(pengeluaran: Pengeluaran)

    @Query("UPDATE pengeluaran SET nama_barang =:pengeluaranNama, harga =:pengeluaranHarga  WHERE id =:pengeluaranId")
    fun update(pengeluaranId: Long, pengeluaranNama: String, pengeluaranHarga: Int)
}