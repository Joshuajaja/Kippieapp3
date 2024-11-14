package com.example.kippie

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Kippiepannen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kippiepannen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pantype = intent.getStringExtra("pantype")  // Retrieve the String extra

        fun loadhapjes() {
            // Load specific admin features, e.g., setting visibility of admin-only views
            val hapjespan = findViewById<View>(R.id.test)
            hapjespan.visibility = View.VISIBLE
        }
        fun loadmaaltijd() {
            // Load specific admin features, e.g., setting visibility of admin-only views
            val maaltijd = findViewById<View>(R.id.changethis)
            maaltijd.visibility = View.VISIBLE
        }
        fun loadvlees() {
            // Load specific admin features, e.g., setting visibility of admin-only views
            val vlees = findViewById<View>(R.id.changethis)
            vlees.visibility = View.VISIBLE
        }
        fun loadvega() {
            // Load specific admin features, e.g., setting visibility of admin-only views
            val vega = findViewById<View>(R.id.changethis)
            vega.visibility = View.VISIBLE
        }
        fun loadXXL() {
            // Load specific admin features, e.g., setting visibility of admin-only views
            val XXL = findViewById<View>(R.id.changethis)
            XXL.visibility = View.VISIBLE
        }

        if (pantype == "hapjes") {
            loadhapjes()
        } else if (pantype == "maaltijdpannen") {
            loadmaaltijd() } else if (pantype == "vleespannen"){
                loadvlees()
        }
        else if (pantype == "vegapannen"){
            loadvega()
        }
        else if (pantype == "XXLpannen"){
            loadXXL()
        }
        }

    }


