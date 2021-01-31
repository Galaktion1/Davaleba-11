package com.example.a19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class FeedActivity : AppCompatActivity() {

    private lateinit var pInfoTextView: TextView
    private lateinit var passwordChangeButton: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var logOutButton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        val navView : BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfig = AppBarConfiguration(setOf(
            R.id.navigation_main, R.id.navigation_dashboard, R.id.navigation_converter
        ))

        setupActionBarWithNavController(navController, appBarConfig)
        navView.setupWithNavController(navController)

        move()

    }
    fun move(){

    }
}