package com.example.tp3final.ui.Fragments

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3final.R
import com.example.tp3final.databinding.LayActivityMainBinding
import com.example.tp3final.databinding.LayFragmentHomeBinding
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
    var _binding: LayFragmentHomeBinding? = null
    val binding get() = _binding!!

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
    ): View {
        _binding = LayFragmentHomeBinding.inflate(inflater,container,false)
        viewRestaurante  = inflater.inflate(R.layout.lay_fragment_home, container, false)
        restauranteRecycler = viewRestaurante.findViewById(R.id.restauranteRecycler)

        binding





        return viewRestaurante


    }

    override fun onStart() {

        super.onStart()
        manager = LinearLayoutManager(context)
        restauranteRecycler.setHasFixedSize(true)
        Log.i("LM","antes layout manager")
        fillRecycler()
        restauranteRecycler.adapter = restauranteAdapter
        restauranteRecycler.layoutManager = manager


    }



    fun checkRecords(){
        db.collection(getString(R.string.res_collection)).get().addOnCompleteListener{}
    }
    private fun fillRecycler(){
        val rootref = FirebaseFirestore.getInstance()
        val query = rootref.collection(getString(R.string.res_collection))
        val options = FirestoreRecyclerOptions.Builder<Restaurante>().setQuery(query,Restaurante::class.java).build()
        Log.i("query",query.toString())
        Log.i("adapter","antes adapter")
        restauranteAdapter = RestauranteAdapter(options)

        restauranteAdapter.startListening()


        Log.i("recycler","termino recycler")
    }

}