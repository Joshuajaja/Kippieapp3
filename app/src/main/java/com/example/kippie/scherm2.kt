package com.example.kippie

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class scherm2 : AppCompatActivity() {

    internal var x1: Float = 0.toFloat()
    internal var x2: Float = 0.toFloat()
    internal var y1: Float = 0.toFloat()
    internal var y2: Float = 0.toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scherm2)
    }

    override fun onTouchEvent(tochevent: MotionEvent): Boolean {
        when (tochevent.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = tochevent.x
                y1 = tochevent.y
            }
            MotionEvent.ACTION_UP -> {
                x2 = tochevent.x
                y2 = tochevent.y

                val deltaX = x2 - x1 // action down en up naar een link rechts converten
                val deltaY = y2 - y1 // met wiskunde die ik niet begrijp

                // Set a minimum threshold for swipe detection to avoid minor accidental movements.
                val SWIPE_THRESHOLD = 50

                // Check if the swipe was more horizontal than vertical and exceeds threshold
                if (Math.abs(deltaX) > Math.abs(deltaY) && Math.abs(deltaX) > SWIPE_THRESHOLD) {
                    if (x1 < x2) {
                        // Right swipe detected (left-to-right)
                        val i = Intent(this@scherm2, MainActivity::class.java)
                        startActivity(i)
                    } else if(x2 < x1) { val i = Intent(this@scherm2, MainActivity2::class.java)
                        startActivity(i)}
                }
            }
        }
        return super.onTouchEvent(tochevent)  // Use super to maintain other touch events
    }

class scherm2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_scherm2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
} }