package com.example.traveleasemad

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker
import android.widget.TextView

class HotelDetailsActivity : AppCompatActivity() {

    private lateinit var hotelDescription: TextView
    private lateinit var bookNowButton: MaterialButton
    private lateinit var checkInDate: TextInputEditText
    private lateinit var checkOutDate: TextInputEditText
    private lateinit var numberOfBeds: TextInputEditText
    private lateinit var numberOfAdults: TextInputEditText
    private lateinit var numberOfChildren: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_details)

        // Initialize views
        hotelDescription = findViewById(R.id.hotelDescription)
        bookNowButton = findViewById(R.id.bookNowButton)
        checkInDate = findViewById(R.id.checkInDate)
        checkOutDate = findViewById(R.id.checkOutDate)
        numberOfBeds = findViewById(R.id.numberOfBeds)
        numberOfAdults = findViewById(R.id.numberOfAdults)
        numberOfChildren = findViewById(R.id.numberOfChildren)

        // Retrieve and display hotel details from the intent
        val hotelDetails = intent.getStringExtra("HOTEL_DETAILS")
        hotelDescription.text = hotelDetails

        // Set up date picker dialogs
        setupDatePickers()

        // Set up book now button listener
        bookNowButton.setOnClickListener {
            // Show toast message
            Toast.makeText(this, "Successfully Booked", Toast.LENGTH_SHORT).show()

            // Create intent to navigate to the booking summary activity
            val intent = Intent(this, BookingSummaryActivity::class.java)
            intent.putExtra("HOTEL_DESCRIPTION", hotelDescription.text.toString())
            intent.putExtra("CHECK_IN_DATE", checkInDate.text.toString())
            intent.putExtra("CHECK_OUT_DATE", checkOutDate.text.toString())
            intent.putExtra("NUMBER_OF_BEDS", numberOfBeds.text.toString())
            intent.putExtra("NUMBER_OF_ADULTS", numberOfAdults.text.toString())
            intent.putExtra("NUMBER_OF_CHILDREN", numberOfChildren.text.toString())
            startActivity(intent)
        }
    }

    private fun setupDatePickers() {
        val datePicker = MaterialDatePicker.Builder.datePicker().build()
        checkInDate.setOnClickListener {
            datePicker.show(supportFragmentManager, "check_in_date_picker")
            datePicker.addOnPositiveButtonClickListener { selection ->
                checkInDate.setText(datePicker.headerText)
            }
        }
        checkOutDate.setOnClickListener {
            datePicker.show(supportFragmentManager, "check_out_date_picker")
            datePicker.addOnPositiveButtonClickListener { selection ->
                checkOutDate.setText(datePicker.headerText)
            }
        }
    }
}
