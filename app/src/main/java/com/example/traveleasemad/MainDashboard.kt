package com.example.traveleasemad
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.traveleasemad.databinding.ActivityMainDashboardBinding


class MainDashboard : AppCompatActivity() {

    private lateinit var binding: ActivityMainDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up click listener for Hotels icon
        binding.iconHotels.setOnClickListener {
            // Start HotelsActivity when the Hotels icon is clicked
            val intent = Intent(this, HotelWall::class.java)
            startActivity(intent)
        }

        binding.iconReviews.setOnClickListener {
            // Start HotelsActivity when the Hotels icon is clicked
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        // Set up click listeners for other icons if needed
        // binding.iconAttractions.setOnClickListener { ... }
        // binding.iconReviews.setOnClickListener { ... }
        // binding.iconSignUp.setOnClickListener { ... }
        // binding.iconSignIn.setOnClickListener { ... }
    }
}
