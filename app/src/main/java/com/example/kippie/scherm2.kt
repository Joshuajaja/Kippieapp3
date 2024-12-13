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
    // Make sure to use the FloatingActionButton for all the FABs
    private lateinit var mAddFab: FloatingActionButton
    private lateinit var mAddAlarmFab: FloatingActionButton
    private lateinit var mAddPersonFab: FloatingActionButton



    // to check whether sub FAB buttons are visible or not.
    private var isAllFabsVisible: Boolean? = null
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

        // Register all the FABs with their IDs This FAB button is the Parent
        mAddFab = findViewById(R.id.FloatingActionButton)

        // FAB button
        mAddAlarmFab = findViewById(R.id.add_alarm_fab2)
        mAddPersonFab = findViewById(R.id.add_person_fab)

        // Also register the action name text, of all the FABs.
        mAddAlarmFab.visibility = View.GONE
        mAddPersonFab.visibility = View.GONE

        // make the boolean     variable as false, as all the
        // action name texts and all the sub FABs are invisible
        isAllFabsVisible = false

        // We will make all the FABs and action name texts
        // visible only when Parent FAB button is clicked So
        // we have to handle the Parent FAB button first, by
        // using setOnClickListener you can see below
        mAddFab.setOnClickListener(View.OnClickListener {
            (if (!isAllFabsVisible!!) {
                // when isAllFabsVisible becomes true make all
                // the action name texts and FABs VISIBLE
                mAddAlarmFab.show()
                mAddPersonFab.show()


                // make the boolean variable true as we
                // have set the sub FABs visibility to GONE
                true
            } else {
                // when isAllFabsVisible becomes true make
                // all the action name texts and FABs GONE.
                mAddAlarmFab.hide()
                mAddPersonFab.hide()


                // make the boolean variable false as we
                // have set the sub FABs visibility to GONE
                false
            }).also { isAllFabsVisible = it }
        })
        val fab: View = findViewById(R.id.FloatingActionButton)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .show()
        }


        val buttonClick5 = findViewById<FloatingActionButton>(R.id.add_person_fab)
        buttonClick5.setOnClickListener {
            val intent = Intent(this, about::class.java)
            startActivity(intent)
        }

        val buttonClick6 = findViewById<FloatingActionButton>(R.id.add_alarm_fab2)
        buttonClick6.setOnClickListener {
            val intent = Intent(this, MainActivityMap::class.java)
            startActivity(intent)
        }
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




