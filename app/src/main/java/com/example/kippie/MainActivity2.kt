package com.example.kippie

import kotlin.collections.List
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class Product(val name: String, val quantity: Int)

class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.productName)
        val quantityTextView: TextView = itemView.findViewById(R.id.productQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.nameTextView.text = product.name
        holder.quantityTextView.text = product.quantity.toString()
    }

    override fun getItemCount() = products.size
}

class MainActivity2 : AppCompatActivity() {

    internal var x1: Float = 0.toFloat()
    internal var x2: Float = 0.toFloat()
    internal var y1: Float = 0.toFloat()
    internal var y2: Float = 0.toFloat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonClick = findViewById<ImageButton>(R.id.withuisjecart)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val buttonClick2 = findViewById<ImageButton>(R.id.witmenucart)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, scherm2::class.java)
            startActivity(intent)
        }




        // Find the RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)

        // Set up a LinearLayoutManager (or GridLayoutManager if you prefer)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val sharedPreferences = getSharedPreferences("pannen", MODE_PRIVATE)
        val products = listOf(
            Product("Antikluif Pan", sharedPreferences.getInt("antikluif", 0)),
            Product("Antikluif Pan 2", sharedPreferences.getInt("antikluif2", 0)),
            Product("Nasi Pan", sharedPreferences.getInt("nasipan", 0)),
            Product("Knak Pan XXL", sharedPreferences.getInt("knakpanxxl", 0)),
            Product("Sate Pan Ketjap", sharedPreferences.getInt("satepanketjap", 0)),
            Product("Aardappel Pan", sharedPreferences.getInt("aardappelpan", 0)),
            Product("Maaltijd Pan", sharedPreferences.getInt("maaltijdpan", 0)),
            Product("Kippeling Pan", sharedPreferences.getInt("kippelingpan", 0)),
            Product("Snack Pan XXL", sharedPreferences.getInt("snackpanxxl", 0))
        ).filter { it.quantity > 0 } // Filter out products with a quantity of 0

        val adapter = ProductAdapter(products)
        recyclerView.adapter = adapter

// Calculate the total of all the variables in the array
        val total = products.sumOf { it.quantity }
        val totaalTextView = findViewById<TextView>(R.id.totaal)
        totaalTextView.text = total.toString()
        val editor = sharedPreferences.edit()


        findViewById<Button>(R.id.bestelKnop).setOnClickListener{
            // Reset all quantities to 0 in SharedPreferences
            editor.putInt("antikluif", 0)
            editor.putInt("antikluif2", 0)
            editor.putInt("nasipan", 0)
            editor.putInt("knakpanxxl", 0)
            editor.putInt("satepanketjap", 0)
            editor.putInt("aardappelpan", 0)
            editor.putInt("maaltijdpan", 0)
            editor.putInt("kippelingpan", 0)
            editor.putInt("snackpanxxl", 0)

            // Apply changes
            editor.apply()

            Toast.makeText(this, "U heeft besteld, bedankt!", Toast.LENGTH_SHORT).show()
        }
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
                    if (x2 < x1) {
                        // Right swipe detected (left-to-right)
                        val i = Intent(this@MainActivity2, MainActivity::class.java)
                        startActivity(i)
                    } else if (x1 < x2) {
                        val i = Intent(this@MainActivity2, scherm2::class.java)
                        startActivity(i)
                    }
                }
            }
        }
        return super.onTouchEvent(tochevent)  // Use super to maintain other touch events
    }
}

