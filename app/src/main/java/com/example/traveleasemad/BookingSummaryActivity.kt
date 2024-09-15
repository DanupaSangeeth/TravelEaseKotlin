package com.example.traveleasemad

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookingSummaryActivity : AppCompatActivity() {

    private lateinit var hotelDescription: TextView
    private lateinit var checkInDate: TextView
    private lateinit var checkOutDate: TextView
    private lateinit var numberOfBeds: TextView
    private lateinit var numberOfAdults: TextView
    private lateinit var numberOfChildren: TextView
    private lateinit var bookingStatus: TextView
    private lateinit var heading: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_summary)

        // Initialize views
        hotelDescription = findViewById(R.id.hotelDescription)
        checkInDate = findViewById(R.id.checkInDate)
        checkOutDate = findViewById(R.id.checkOutDate)
        numberOfBeds = findViewById(R.id.numberOfBeds)
        numberOfAdults = findViewById(R.id.numberOfAdults)
        numberOfChildren = findViewById(R.id.numberOfChildren)
        bookingStatus = findViewById(R.id.bookingStatus)
        heading = findViewById(R.id.heading)

        // Retrieve and display booking details from the intent
        val extras = intent.extras
        hotelDescription.text = "Hotel Description: ${extras?.getString("HOTEL_DESCRIPTION")}"
        checkInDate.text = "Check-In Date: ${extras?.getString("CHECK_IN_DATE")}"
        checkOutDate.text = "Check-Out Date: ${extras?.getString("CHECK_OUT_DATE")}"
        numberOfBeds.text = "Number of Beds: ${extras?.getString("NUMBER_OF_BEDS")}"
        numberOfAdults.text = "Number of Adults: ${extras?.getString("NUMBER_OF_ADULTS")}"
        numberOfChildren.text = "Number of Children: ${extras?.getString("NUMBER_OF_CHILDREN")}"

        // Set the booking status
        bookingStatus.text = "Booked"
    }
}
