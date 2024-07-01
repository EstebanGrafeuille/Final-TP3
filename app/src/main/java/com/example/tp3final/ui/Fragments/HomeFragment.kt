package com.example.tp3final.ui.Fragments

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3final.R
import com.example.tp3final.ui.Adapters.RestauranteAdapter
import com.example.tp3final.ui.Viewmodels.ResViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.example.tp3final.ui.Entities.Restaurante
import com.firebase.ui.firestore.FirestoreRecyclerOptions


class HomeFragment : Fragment() {

    private lateinit var viewModel: ResViewModel

    lateinit var restauranteRecycler: RecyclerView
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var viewRestaurante:View
    lateinit var restauranteAdapter: RestauranteAdapter

    val db = Firebase.firestore

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ResViewModel::class)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewRestaurante  = inflater.inflate(R.layout.lay_fragment_home, container, false)
        restauranteRecycler = viewRestaurante.findViewById(R.id.restauranteRecycler)
        return viewRestaurante
    }

    override fun onStart() {

        super.onStart()
        restauranteRecycler.setHasFixedSize(true)
        manager = LinearLayoutManager(context)
        fillRecycler()

        restauranteRecycler.layoutManager = manager
        restauranteRecycler.adapter = restauranteAdapter
    }


    fun checkRecords(){
        db.collection(getString(R.string.res_collection)).get().addOnCompleteListener{}
    }
    fun fillRecycler(){
        val rootref = FirebaseFirestore.getInstance()
        val query = rootref.collection(getString(R.string.res_collection))
        val options = FirestoreRecyclerOptions.Builder<Restaurante>().setQuery(query,Restaurante::class.java).build()
        restauranteAdapter = RestauranteAdapter(options)
    }

}