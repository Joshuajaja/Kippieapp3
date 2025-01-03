package com.example.kippie

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    internal var x1: Float = 0.toFloat()
    internal var x2: Float = 0.toFloat()
    internal var y1: Float = 0.toFloat()
    internal var y2: Float = 0.toFloat()


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
                    if (x2 < x1) {
                        // Right swipe detected (left-to-right)
                        val i = Intent(this@MainActivity, scherm2::class.java)
                        startActivity(i)
                    } else if (x1 < x2) {
                        val r = Intent(this@MainActivity, MainActivity2::class.java)
                        startActivity(r)}
                }
            }
        }
        return super.onTouchEvent(tochevent)  // Use super to maintain other touch events
    }

    // Make sure to use the FloatingActionButton for all the FABs
    private lateinit var mAddFab: FloatingActionButton
    private lateinit var mAddAlarmFab: FloatingActionButton
    private lateinit var mAddPersonFab: FloatingActionButton



    // to check whether sub FAB buttons are visible or not.
    private var isAllFabsVisible: Boolean? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
        mAddFab.setOnClickListener {
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
        }
        // below is the sample action to handle add person FAB. Here it shows simple Toast msg.
        // The Toast will be shown only when they are visible and only when user clicks on them

        val buttonClick = findViewById<ImageButton>(R.id.witmenuhome)
        buttonClick.setOnClickListener {
            val intent = Intent(this, scherm2::class.java)
            startActivity(intent)
        }

        val buttonClick2 = findViewById<ImageButton>(R.id.witkarretjehome)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

            val fab: View = findViewById(R.id.FloatingActionButton)
            fab.setOnClickListener { view ->
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show()
            }
        }

        val buttonClick5 = findViewById<FloatingActionButton>(R.id.add_person_fab)
        buttonClick5.setOnClickListener {
            val intent = Intent(this, about ::class.java)
            startActivity(intent)
        }

        val buttonClick6 = findViewById<FloatingActionButton>(R.id.add_alarm_fab2)
        buttonClick6.setOnClickListener {
            val intent = Intent(this, MainActivityMap ::class.java)
            startActivity(intent)
        }

    }
    }



