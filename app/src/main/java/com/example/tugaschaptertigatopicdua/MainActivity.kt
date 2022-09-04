package com.example.tugaschaptertigatopicdua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var edtUmur : EditText
    lateinit var edtTinggi : EditText
    lateinit var edtBerat : EditText
    lateinit var btnIntent : Button
    lateinit var btnBundle : Button
    lateinit var btnSerializable : Button
    lateinit var btnParcelable : Button
    lateinit var umurUser : String
    lateinit var tinggiUser : String
    lateinit var beratUser : String
    lateinit var kategori : String
    var hasilBMI : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUmur = findViewById(R.id.edt_umur)
        edtTinggi = findViewById(R.id.edt_tinggi)
        edtBerat = findViewById(R.id.edt_berat)

        btnIntent = findViewById(R.id.btn_intent)
        btnBundle = findViewById(R.id.btn_bundle)
        btnSerializable = findViewById(R.id.btn_serializable)
        btnParcelable = findViewById(R.id.btn_parcelable)

        btnIntent.setOnClickListener{
            hitungBMI()
            sendIntent()
        }

        btnBundle.setOnClickListener{
            hitungBMI()
            sendBundle()
        }

        btnSerializable.setOnClickListener{
            hitungBMI()
            sendSerializable()
        }

        btnParcelable.setOnClickListener{
            hitungBMI()
            sendParcelable()
        }
    }

    fun hitungBMI() {
        var umur = edtUmur.text.toString()
        var tinggi = edtTinggi.text.toString()
        var berat = edtBerat.text.toString()

        var tinggiDalamMeter = tinggi.toDouble()/100
        var tinggiDalamKuadrat = tinggiDalamMeter*tinggiDalamMeter
        var totalBMI = berat.toFloat()/tinggiDalamKuadrat

        if(totalBMI.toDouble() < 16){
            kategori = "Terlalu Kurus"
        }else if(totalBMI.toDouble() in 16.1..17.0){
            kategori = "Cukup Kurus"
        }else if(totalBMI.toDouble() in 17.1..18.5){
            kategori = "Sedikit Kurus"
        }else if(totalBMI.toDouble() in 18.6..25.0){
            kategori = "Normal"
        }else if(totalBMI.toDouble() in 25.1..30.0){
            kategori = "Gemuk"
        }else if(totalBMI.toDouble() in 30.0..35.0){
            kategori = "Obesitas Kelas 1"
        }else if(totalBMI.toDouble() in 35.1..40.0){
            kategori = "Obesitas Kelas 2"
        }else{
            kategori ="Obesitas Kelas 3"
        }
    }

    fun sendIntent() {
        val i = Intent(this, HasilBMI::class.java)
        i.putExtra("method", "1")
        i.putExtra("umur", umurUser)
        i.putExtra("tinggi", tinggiUser)
        i.putExtra("berat", beratUser)
        i.putExtra("bmi", hasilBMI.toString())
        i.putExtra("kategori", kategori)
        startActivity(i)
    }

    fun sendBundle() {
        val bundleBMI = Bundle()
        val i = Intent(this, HasilBMI::class.java)
        bundleBMI.putString("umur", umurUser)
        bundleBMI.putString("tinggi", tinggiUser)
        bundleBMI.putString("berat", beratUser)
        bundleBMI.putDouble("bmi", hasilBMI)
        bundleBMI.putString("kategori", kategori)
        i.putExtras(bundleBMI)
        i.putExtra("method", "2")
        startActivity(i)
    }

    fun sendSerializable() {
        val i = Intent(this, HasilBMI::class.java)
        val dataSerializable = BMISerializable(umurUser, tinggiUser, beratUser, hasilBMI, kategori)
        i.putExtra("method", "3")
        i.putExtra("dataBMISerializable", dataSerializable)
        startActivity(i)
    }

    fun sendParcelable() {
        val i = Intent(this, HasilBMI::class.java)
        val dataParcelable = BMIParcelable(umurUser, tinggiUser, beratUser, hasilBMI, kategori)
        i.putExtra("method", "4")
        i.putExtra("dataBMIParcelable", dataParcelable)
        startActivity(i)
    }
}