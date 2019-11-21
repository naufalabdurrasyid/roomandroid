package com.example.dokuku

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = arrayOf(Pengeluaran::class), version = 2)
 abstract class PengeluaranDatabase : RoomDatabase(){

    abstract fun pengeluaranDao(): PengeluaranDao

    companion object {
        private var INSTANCE: PengeluaranDatabase? = null
        fun getInstance(context: Context): PengeluaranDatabase? {
            if (INSTANCE == null) {
                synchronized(PengeluaranDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        PengeluaranDatabase::class.java, "pengeluarandata.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }

    }



}
