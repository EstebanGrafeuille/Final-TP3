package com.example.tp3final.ui.Activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp3final.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FireActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_fragment_home)
    }


}