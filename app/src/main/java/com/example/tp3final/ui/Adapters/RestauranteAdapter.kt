package com.example.tp3final.ui.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3final.R
import com.example.tp3final.ui.Entities.Restaurante
import com.example.tp3final.ui.Holders.RestauranteHolder
import com.example.tp3final.ui.Interfaces.RecycleViewInterface
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class RestauranteAdapter(private val restaurantes: FirestoreRecyclerOptions<Restaurante>):RecycleViewInterface,
    FirestoreRecyclerAdapter<Restaurante, RestauranteHolder>(restaurantes)  {

    private lateinit var mListener: RecycleViewInterface

    fun setOnItemClickListener(clickListener: RecycleViewInterface){
        mListener = clickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_restaurante,parent,false)
        Log.i("adapter", "llego a adapter")
        return(RestauranteHolder(view,mListener))

    }

    override fun onBindViewHolder(holder: RestauranteHolder, position: Int, model: Restaurante) {
        model.nombre?.let { Log.i("setting item", it) }
        model.nombre?.let { holder.setTitle(it) }
        model.tipo?.let { holder.settipo(it) }
        model.rating?.let { holder.setRating(it) }

    }

    override fun onItemClick(pos: Int) {
        TODO("Not yet implemented")
    }
}