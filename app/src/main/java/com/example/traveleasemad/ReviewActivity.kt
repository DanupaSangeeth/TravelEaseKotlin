package com.example.traveleasemad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReviewActivity : AppCompatActivity() {

    private lateinit var ratingBar: RatingBar
    private lateinit var editTextReview: EditText
    private lateinit var btnSubmitReview: Button
    private lateinit var recyclerViewReviews: RecyclerView
    private lateinit var reviewAdapter: ReviewAdapter
    private val reviewsList = mutableListOf<Review>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        ratingBar = findViewById(R.id.ratingBar)
        editTextReview = findViewById(R.id.editTextReview)
        btnSubmitReview = findViewById(R.id.btnSubmitReview)
        recyclerViewReviews = findViewById(R.id.recyclerViewReviews)

        reviewAdapter = ReviewAdapter(reviewsList)
        recyclerViewReviews.layoutManager = LinearLayoutManager(this)
        recyclerViewReviews.adapter = reviewAdapter

        btnSubmitReview.setOnClickListener {
            val rating = ratingBar.rating
            val reviewText = editTextReview.text.toString()

            if (reviewText.isNotEmpty()) {
                val review = Review(rating, reviewText)
                reviewsList.add(review)
                reviewAdapter.notifyDataSetChanged()
                editTextReview.text.clear()
                ratingBar.rating = 0f
            }
        }
    }
}
