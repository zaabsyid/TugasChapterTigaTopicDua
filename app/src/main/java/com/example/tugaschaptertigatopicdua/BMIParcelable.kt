package com.example.tugaschaptertigatopicdua

import android.os.Parcel
import android.os.Parcelable

data class BMIParcelable(val umur : String, val tinggi : String, val berat : String, val bmi : Double, val kategori : String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(umur)
        parcel.writeString(tinggi)
        parcel.writeString(berat)
        parcel.writeDouble(bmi)
        parcel.writeString(kategori)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BMIParcelable> {
        override fun createFromParcel(parcel: Parcel): BMIParcelable {
            return BMIParcelable(parcel)
        }

        override fun newArray(size: Int): Array<BMIParcelable?> {
            return arrayOfNulls(size)
        }
    }
}