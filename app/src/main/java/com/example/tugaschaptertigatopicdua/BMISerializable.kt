package com.example.tugaschaptertigatopicdua

import java.io.Serializable

data class BMISerializable (val umur : String, val tinggi : String, val berat : String, val bmi : Double, val kategori : String) :
    Serializable