package com.example.tp3final.ui.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tp3final.R
import com.example.tp3final.ui.Entities.MenuItem
import com.example.tp3final.ui.Entities.Restaurante
import com.example.tp3final.ui.Holders.MenuItemHolder
import com.example.tp3final.ui.Holders.RestauranteHolder
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class MenuItemAdapter (val menuItems : FirestoreRecyclerOptions<MenuItem>):
    FirestoreRecyclerAdapter<MenuItem,MenuItemHolder>(menuItems) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lay_menu_item,parent,false)
        return (MenuItemHolder(view))
    }

    override fun onBindViewHolder(holder: MenuItemHolder, position: Int, model: MenuItem) {
        model.nombre?.let { holder.setNombre(it) }
        model.precio?.let { holder.setPrice(it) }
    }

}