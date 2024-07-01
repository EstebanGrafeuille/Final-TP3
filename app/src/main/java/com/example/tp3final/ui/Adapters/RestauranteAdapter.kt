package com.example.tp3final.ui.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3final.R
import com.example.tp3final.ui.Entities.Restaurante
import com.example.tp3final.ui.Holders.RestauranteHolder
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class RestauranteAdapter(val restaurantes: FirestoreRecyclerOptions<Restaurante>) : FirestoreRecyclerAdapter<Restaurante, RestauranteHolder>(restaurantes)  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_restaurante,parent,false)
        return(RestauranteHolder(view))
    }

    override fun onBindViewHolder(holder: RestauranteHolder, position: Int, model: Restaurante) {
        holder.setTitle(model.nombre)
        holder.settipo(model.tipo)
        holder.setRating(model.rating)
    }



}