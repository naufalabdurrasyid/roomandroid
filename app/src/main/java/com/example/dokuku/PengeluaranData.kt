package com.example.dokuku

object PengeluaranData {
    private val pengeluaranNama = arrayOf("Pendidikan",
//        "Olahraga",
        "Kesehatan",
        "Elektronik",
        "Tagihan",
        "Makanan",
        "Hiburan",
//        "Amal",
        "Transportasi",
        "Lainnya")



    private val pengeluaranFoto = intArrayOf(R.drawable.pendidikan,
//        R.drawable.olahraga,
        R.drawable.kesehatan,
        R.drawable.elektronik,
        R.drawable.tagihan,
        R.drawable.makanan,
        R.drawable.hiburan,
//        R.drawable.amal,
        R.drawable.transportasi,
        R.drawable.lainnya)

    val dataPengeluaran: ArrayList<Data>
        get() {
            val list = arrayListOf<Data>()
            for (position in pengeluaranNama.indices) {
                val data = Data()
                data.name = pengeluaranNama[position]
                data.photo = pengeluaranFoto[position]
                list.add(data)
            }
            return list
        }
}