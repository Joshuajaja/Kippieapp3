package com.example.kippie

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class scherm2 : AppCompatActivity() {
    override fun onTouchEvent(touchevent: MotionEvent): Boolean {
        // Set the content view to activity_scherm2 layout
        setContentView(R.layout.activity_scherm2)
        when (touchevent.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = touchevent.x
                y1 = touchevent.y
            }

            MotionEvent.ACTION_UP -> {
                x2 = touchevent.x
                y2 = touchevent.y

                val deltaX = x2 - x1
                val deltaY = y2 - y1

                // Swipe threshold to prevent accidental minor movements
                val SWIPE_THRESHOLD = 50

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
        return super.onTouchEvent(touchevent)  // Use super to maintain other touch events
    }

    private var x1: Float = 0.0f
    private var x2: Float = 0.0f
    private var y1: Float = 0.0f
    private var y2: Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scherm2)
        // Set up button listeners with Intent data
        findViewById<Button>(R.id.hapjespannen).setOnClickListener {
            val intent = Intent(this@scherm2, Kippiepannen::class.java)
            intent.putExtra("pantype", "hapjes")
            startActivity(intent)
        }

        findViewById<Button>(R.id.Maaltijdpannen).setOnClickListener {
            val intent = Intent(this@scherm2, Kippiepannen::class.java)
            intent.putExtra("pantype", "maaltijdpannen")
            startActivity(intent)
        }

        findViewById<Button>(R.id.Vleespannen).setOnClickListener {
            val intent = Intent(this@scherm2, Kippiepannen::class.java)
            intent.putExtra("pantype", "Vleespannen")
            startActivity(intent)
        }
        findViewById<Button>(R.id.Vleespannen).setOnClickListener {
            val intent = Intent(this@scherm2, Kippiepannen::class.java)
            intent.putExtra("pantype", "Vleespannen")
            startActivity(intent)
        }
        findViewById<Button>(R.id.Vegapannen).setOnClickListener {
            val intent = Intent(this@scherm2, Kippiepannen::class.java)
            intent.putExtra("pantype", "Vegapannen")
            startActivity(intent)
        }

        findViewById<Button>(R.id.XXLpannen).setOnClickListener {
            val intent = Intent(this@scherm2, Kippiepannen::class.java)
            intent.putExtra("pantype", "XXLpan")
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonClick = findViewById<ImageButton>(R.id.withuisjemenu)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonClick2 = findViewById<ImageButton>(R.id.imageButton5)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }


    }




