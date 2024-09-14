package com.example.traveleasemad

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.traveleasemad.R

class HotelWall : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hotelwall)

        val getStartedTextView: TextView = findViewById(R.id.textGetStarted)

        // Set a click listener on the TextView
        getStartedTextView.setOnClickListener {
            // Navigate to HotelDashboard when the TextView is clicked
            val intent = Intent(this, HotelDashboardActivity::class.java)
            startActivity(intent)

            // Initialize views
            val imageView = findViewById<ImageView>(R.id.imageView)
            val textView = findViewById<TextView>(R.id.textView3)
            val getStartedTextView = findViewById<TextView>(R.id.textGetStarted)
            val arrowImageView = findViewById<ImageView>(R.id.imageView2)

            // Set a click listener on the "Get Started" text and image
            getStartedTextView.setOnClickListener {
                // Action on Get Started click, you can navigate to another activity or show a message
                // Example: Toast message
                Toast.makeText(this, "Get Started clicked!", Toast.LENGTH_SHORT).show()

                // You can start a new activity like this
                // val intent = Intent(this, NextActivity::class.java)
                // startActivity(intent)
            }

            arrowImageView.setOnClickListener {
                // Similar action for arrow click if needed
                Toast.makeText(this, "Arrow clicked!", Toast.LENGTH_SHORT).show()

                // Example for starting a new activity
                // val intent = Intent(this, NextActivity::class.java)
                // startActivity(intent)
            }
        }
    }
    }
