package com.example.tp3final.ui.Holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3final.R

class RestauranteHolder  (v: View): RecyclerView.ViewHolder(v)  {

    private var view:View
    init{
        this.view = v
    }

    fun setTitle(titletext:String){
        val title: TextView = view.findViewById(R.id.title_text)
        title.text = titletext
    }

    fun settipo(type:String){
        val tipo: TextView = view.findViewById(R.id.tipo_text)
        tipo.text = type
    }

    fun setRating(rating:Float){
        val rating: TextView = view.findViewById(R.id.rating_text)
        rating.text = rating.text
    }
}