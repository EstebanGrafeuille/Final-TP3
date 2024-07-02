package com.example.tp3final.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.tp3final.R
import com.example.tp3final.databinding.LayFragmentRestDetailsBinding
import com.example.tp3final.ui.Entities.Restaurante
import com.example.tp3final.ui.Viewmodels.ResDetailViewModel

class RestDetailsFrag : Fragment() {
    private var _binding: LayFragmentRestDetailsBinding? = null
    private val binding get() = _binding!!
    private var restaurante : Restaurante? = null
    private lateinit var root : View
    //private val viewModel : ResDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayFragmentRestDetailsBinding.inflate(inflater, container, false)
        root = binding.root
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}