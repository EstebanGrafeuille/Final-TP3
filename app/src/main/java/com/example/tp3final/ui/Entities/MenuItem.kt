package com.example.tp3final.ui.Entities

import android.os.Parcel
import android.os.Parcelable

class MenuItem(price:Int?,name:String?):Parcelable {

    var precio:Int = 0
    var nombre:String = ""
    constructor() : this(0,"")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeValue(precio)
    }

    override fun describeContents(): Int {
        return 0
    }

    constructor(source: Parcel) : this(
        source.readInt(),
        source.readString()!!
    )

    companion object CREATOR : Parcelable.Creator<MenuItem> {
        override fun createFromParcel(parcel: Parcel): MenuItem {
            return MenuItem(parcel)
        }

        override fun newArray(size: Int): Array<MenuItem?> {
            return arrayOfNulls(size)
        }
    }

}