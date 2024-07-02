package com.example.tp3final.ui.Activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tp3final.R
import com.example.tp3final.databinding.LayActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation : BottomNavigationView
    private lateinit var navHostFragment : NavHostFragment
    private lateinit var navController : NavController

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.lay_activity_main)

        val orderButton: Button = findViewById(R.id.buttonSplash)
        orderButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

            navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment

            navController = navHostFragment.navController

            bottomNavigation = findViewById(R.id.bottom_bar)

            NavigationUI.setupWithNavController(bottomNavigation, navHostFragment.navController)
        }
    }}