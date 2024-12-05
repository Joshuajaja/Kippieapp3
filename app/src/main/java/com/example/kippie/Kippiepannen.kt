package com.example.kippie

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
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
            val hapjespan3 = findViewById<View>(R.id.antikluifbutton2)
            hapjespan3.visibility = View.VISIBLE
            val hapjespan4 = findViewById<View>(R.id.antikluifbutton)
            hapjespan4.visibility = View.VISIBLE
        }
        fun loadmaaltijd() {
           val maaltijd = findViewById<View>(R.id.maaltijdpan)
           maaltijd.visibility = View.VISIBLE
            val maaltijd3 = findViewById<View>(R.id.nasipan)
            maaltijd3.visibility = View.VISIBLE
            val maaltijd2 = findViewById<View>(R.id.maaltijdpanbutton)
            maaltijd2.visibility = View.VISIBLE
            val maaltijd4 = findViewById<View>(R.id.nasipanbutton)
            maaltijd4.visibility = View.VISIBLE
        }
        fun loadvlees() {
            val vlees = findViewById<View>(R.id.satepanketjap)
            vlees.visibility = View.VISIBLE
            val vlees3 = findViewById<View>(R.id.kippelingpan)
            vlees3.visibility = View.VISIBLE
            val vlees2 = findViewById<View>(R.id.satepanketjapbutton)
            vlees2.visibility = View.VISIBLE
            val vlees4 = findViewById<View>(R.id.Kippelingpanbutton)
            vlees4.visibility = View.VISIBLE
        }
        fun loadvega() {
           val vega = findViewById<View>(R.id.imageaardappel)
           vega.visibility = View.VISIBLE
            val vega3 = findViewById<View>(R.id.maaltijdpan)
            vega3.visibility = View.VISIBLE
            val vega4 = findViewById<View>(R.id.aardappelpanbutton)
            vega4.visibility = View.VISIBLE
            val vega2 = findViewById<View>(R.id.maaltijdpanbutton)
            vega2.visibility = View.VISIBLE
        }
        fun loadXXL() {
            val xxl = findViewById<View>(R.id.knakpanXxl)
            xxl.visibility = View.VISIBLE
            val xxl3 = findViewById<View>(R.id.snackpanXxl)
            xxl3.visibility = View.VISIBLE
            val xxl2 = findViewById<View>(R.id.knakpanXxlbutton)
            xxl2.visibility = View.VISIBLE
            val xxl4 = findViewById<View>(R.id.SnackpanXxlbutton)
            xxl4.visibility = View.VISIBLE
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
        val sharedPreferences = getSharedPreferences("pannen", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
var y = 0
        findViewById<Button>(R.id.antikluifbutton2).setOnClickListener {
           y = y+1
            editor.putInt("antikluif2", y)
            editor.apply()
            Toast.makeText(this, "1 Antikluif schotel is toegevoegd", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.antikluifbutton).setOnClickListener {
            y = y+1
            editor.putInt("antikluif", y)
            editor.apply()
            Toast.makeText(this, "1 Antikluif schotel is toegevoegd", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.nasipanbutton).setOnClickListener {
            y = y+1
            editor.putInt("nasipan", y)
            editor.apply()
            Toast.makeText(this, "1 Nasi pan is toegevoegd", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.knakpanXxlbutton).setOnClickListener {
            y = y+1
            editor.putInt("knakpanxxl", y)
            editor.apply()
            Toast.makeText(this, "1 Knakpan XXL is toegevoegd", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.satepanketjapbutton).setOnClickListener {
            y = y+1
            editor.putInt("satepanketjap", y)
            editor.apply()
            Toast.makeText(this, "1 Satepan ketjap is toegevoegd", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.aardappelpanbutton).setOnClickListener {
            y = y+1
            editor.putInt("aardappelpan", y)
            editor.apply()
            Toast.makeText(this, "1 Aardappel pan is toegevoegd", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.maaltijdpanbutton).setOnClickListener {
            y = y+1
            editor.putInt("maaltijdpan", y)
            editor.apply()
            Toast.makeText(this, "1 Maaltijd pan is toegevoegd", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.Kippelingpanbutton).setOnClickListener {
            y = y+1
            editor.putInt("kippelingpan", y)
            editor.apply()
            Toast.makeText(this, "1 Kippeling pan is toegevoegd", Toast.LENGTH_SHORT).show()
        }
        findViewById<Button>(R.id.SnackpanXxlbutton).setOnClickListener {
            y = y+1
            editor.putInt("snackpanxxl", y)
            editor.apply()
                Toast.makeText(this, "1 Snackpan XXL is toegevoegd", Toast.LENGTH_SHORT).show()
        }



        }

    }


