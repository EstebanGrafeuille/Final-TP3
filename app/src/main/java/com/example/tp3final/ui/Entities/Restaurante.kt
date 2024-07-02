package com.example.tp3final.ui.Entities

import android.os.Parcel
import android.os.Parcelable

class Restaurante(var nombre:String?, var direccion:String?, var rating: Double, var tipo:String?,) : Parcelable {
     val name:String = ""
     var dir:String = ""
     var rate:Double = 0.0
     var type:String = ""
     constructor() : this("","",0.0,"")

     override fun writeToParcel(parcel: Parcel, flags: Int) {
         parcel.writeString(nombre)
         parcel.writeString(direccion)
         parcel.writeValue(rating)
         parcel.writeString(tipo)
     }

    init {
        this.nombre = name!!
        this.tipo = type!!
        this.rating = rate!!
        this.direccion = dir!!


    }

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readDouble(),
        source.readString()!!
    )

     override fun describeContents(): Int {
         return 0
     }

     companion object CREATOR : Parcelable.Creator<Restaurante> {
         override fun createFromParcel(parcel: Parcel): Restaurante {
             return Restaurante(parcel)
         }

         override fun newArray(size: Int): Array<Restaurante?> {
             return arrayOfNulls(size)
         }
     }
 }
