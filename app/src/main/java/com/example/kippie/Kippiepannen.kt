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
            val hapjespan = findViewById<View>(R.id.test)
            hapjespan.visibility = View.VISIBLE
        }
        fun loadmaaltijd() {
            val maaltijd = findViewById<View>(R.id.maaltijd)
            maaltijd.visibility = View.VISIBLE
        }
        fun loadvlees() {
            val vlees = findViewById<View>(R.id.vlees)
            vlees.visibility = View.VISIBLE
        }
        fun loadvega() {
            val vega = findViewById<View>(R.id.vega)
            vega.visibility = View.VISIBLE
        }
        fun loadXXL() {
            val XXL = findViewById<View>(R.id.xxl)
            XXL.visibility = View.VISIBLE
        }

        if (pantype == "hapjes") {
            loadhapjes()
        } else if (pantype == "maaltijdpannen") {
            loadmaaltijd() }
        else if (pantype == "Vleespannen"){
                loadvlees()
        }
        else if (pantype == "Vegapannen"){
            loadvega()
        }
        else if (pantype == "XXLpan"){
            loadXXL()
        }
        }

    }


