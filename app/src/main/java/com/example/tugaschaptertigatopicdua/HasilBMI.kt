package com.example.tugaschaptertigatopicdua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HasilBMI : AppCompatActivity() {

    lateinit var tvMetode : TextView
    lateinit var tvUmur : TextView
    lateinit var tvTinggi : TextView
    lateinit var tvBerat : TextView
    lateinit var tvBMI : TextView
    lateinit var tvKategori : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_bmi)

        tvMetode = findViewById(R.id.tv_method)
        tvUmur = findViewById(R.id.tv_umur)
        tvBerat = findViewById(R.id.tv_berat)
        tvTinggi = findViewById(R.id.tv_tinggi)
        tvBMI = findViewById(R.id.tv_bmi)
        tvKategori = findViewById(R.id.tv_kategori)

        val cekMethod = intent.getStringExtra("method")
        if(cekMethod == "1"){
            ambilDataIntent()
        }else if(cekMethod == "2"){
            ambilDataBundle()
        }else if(cekMethod == "3"){
            ambilDataSerializable()
        }else if(cekMethod == "4"){
            ambilDataParcelable()
        }
    }

    fun ambilDataParcelable() {
        val dataPar = intent.getParcelableExtra("dataBMIParcelable") as BMIParcelable?
        tvMetode.text = "Parcelable"
        tvUmur.text = dataPar?.umur
        tvTinggi.text = dataPar?.tinggi
        tvBerat.text = dataPar?.berat
        tvBMI.text = dataPar?.bmi.toString()
        tvKategori.text = dataPar?.kategori
    }

    fun ambilDataSerializable() {
        val dataBMISerializable = intent.getSerializableExtra("dataBMISerializable") as BMISerializable
        tvMetode.text = "Serializable"
        tvUmur.text = dataBMISerializable.umur
        tvTinggi.text = dataBMISerializable.tinggi
        tvBerat.text = dataBMISerializable.berat
        tvBMI.text = dataBMISerializable.bmi.toString()
        tvKategori.text = dataBMISerializable.kategori
    }

    fun ambilDataBundle() {
        val bundle = intent.extras
        tvMetode.text = "Bundle"
        tvUmur.text = bundle!!.getString("umur")
        tvTinggi.text = bundle.getString("tinggi")
        tvBerat.text = bundle.getString("berat")
        tvBMI.text = bundle.getDouble("bmi").toString()
        tvKategori.text = bundle.getString("kategori")
    }

    fun ambilDataIntent() {
        val dataUmur = intent.getStringExtra("umur")
        val dataTinggi = intent.getStringExtra("tinggi")
        val dataBerat = intent.getStringExtra("berat")
        val dataBMI = intent.getStringExtra("bmi")
        val dataKategori = intent.getStringExtra("kategori")

        tvMetode.text = "Intent"
        tvUmur.text = dataUmur
        tvTinggi.text = dataTinggi
        tvBerat.text = dataBerat
        tvBMI.text = dataBMI
        tvKategori.text = dataKategori
    }
}