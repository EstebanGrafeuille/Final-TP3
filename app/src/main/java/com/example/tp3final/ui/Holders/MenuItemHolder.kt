package com.example.tp3final.ui.Holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3final.R

class MenuItemHolder(v:View):RecyclerView.ViewHolder(v) {
    private var view:View
    init{
        this.view = v
    }

    fun setNombre(name:String){
        val nombre: TextView = view.findViewById(R.id.name_menu_item)
        nombre.text = name
    }

    fun setPrice(price:Int){
        val precio: TextView = view.findViewById(R.id.price_menu_item)
    }
}