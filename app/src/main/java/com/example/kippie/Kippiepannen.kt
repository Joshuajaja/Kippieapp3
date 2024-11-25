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
            val hapjespan = findViewById<View>(R.id.antikluif)
            hapjespan.visibility = View.VISIBLE
            val hapjespan2 = findViewById<View>(R.id.antikluif2)
            hapjespan2.visibility = View.VISIBLE
            val hapjespan3 = findViewById<View>(R.id.antikluiftext)
            hapjespan3.visibility = View.VISIBLE
            val hapjespan4 = findViewById<View>(R.id.antikluiftext2)
            hapjespan4.visibility = View.VISIBLE
        }
        fun loadmaaltijd() {
       //     val maaltijd = findViewById<View>(R.id.)
      //      maaltijd.visibility = View.VISIBLE
        }
        fun loadvlees() {
  //          val vlees = findViewById<View>(R.id.vlees)
         //   vlees.visibility = View.VISIBLE
        }
        fun loadvega() {
           val vega = findViewById<View>(R.id.imageaardappel)
           vega.visibility = View.VISIBLE
            val vega2 = findViewById<View>(R.id.aardappelpan)
            vega2.visibility = View.VISIBLE
            val vega3 = findViewById<View>(R.id.maaltijdpan)
            vega3.visibility = View.VISIBLE
            val vega4 = findViewById<View>(R.id.maaltijdpantext)
            vega4.visibility = View.VISIBLE
        }
        fun loadXXL() {
     //       val XXL = findViewById<View>(R.id.xxl)
    //        XXL.visibility = View.VISIBLE
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


