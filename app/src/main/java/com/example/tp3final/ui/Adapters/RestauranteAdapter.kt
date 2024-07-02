package com.example.tp3final.ui.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3final.R
import com.example.tp3final.ui.Entities.Restaurante
import com.example.tp3final.ui.Holders.RestauranteHolder
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class RestauranteAdapter(private val restaurantes: FirestoreRecyclerOptions<Restaurante>) :
    FirestoreRecyclerAdapter<Restaurante, RestauranteHolder>(restaurantes)  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_restaurante,parent,false)
        Log.i("adapter", "llego a adapter")
        return(RestauranteHolder(view))
    }

    override fun onBindViewHolder(holder: RestauranteHolder, position: Int, model: Restaurante) {
        model.nombre?.let { holder.setTitle(it) }
        model.tipo?.let { holder.settipo(it) }
        model.rating?.let { holder.setRating(it) }
    }



}