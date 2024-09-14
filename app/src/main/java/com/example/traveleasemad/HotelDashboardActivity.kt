package com.example.traveleasemad

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HotelDashboardActivity : AppCompatActivity() {

    // Declare all the views
    private lateinit var profileImageView: ImageView
    private lateinit var welcomeTextView: TextView
    private lateinit var userNameTextView: TextView
    private lateinit var notificationBellImageView: ImageView
    private lateinit var findStayTextView: TextView
    private lateinit var searchEditText: EditText
    private lateinit var settingsImageView: ImageView
    private lateinit var popularRecyclerView: RecyclerView
    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var profileButton: ImageView
    private lateinit var savedIcon: ImageView  // Declare savedIcon here

    // Define the categories list
    private val categories = listOf("Hotels", "Adventures")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hotels_dashboard)

        // Initialize the views
        profileImageView = findViewById(R.id.imageView3)
        welcomeTextView = findViewById(R.id.textView5)
        userNameTextView = findViewById(R.id.textView6)
        notificationBellImageView = findViewById(R.id.imageView4)
        findStayTextView = findViewById(R.id.textView8)
        searchEditText = findViewById(R.id.editTextText7)
        settingsImageView = findViewById(R.id.imageView5)
        popularRecyclerView = findViewById(R.id.view_pop)
        categoryRecyclerView = findViewById(R.id.view_category)
        bottomAppBar = findViewById(R.id.app_bar)
        profileButton = findViewById(R.id.imageView7)
        savedIcon = findViewById(R.id.imageView8) // Initialize savedIcon here

        // Set up click listener for the saved icon
        savedIcon.setOnClickListener {
            // Create an Intent to navigate to BookingSummaryActivity
            val intent = Intent(this, BookingSummaryActivity::class.java)
            // Optionally, add extras to the Intent if needed
            // intent.putExtra("EXTRA_KEY", "value")
            startActivity(intent)
        }

        // Set up RecyclerView for categories
        categoryRecyclerView.layoutManager = GridLayoutManager(this, 1) // 1 column
        categoryRecyclerView.adapter = CategoryAdapter(categories) { category ->
            handleCategoryClick(category)
        }

        // Handle the settings button click
        settingsImageView.setOnClickListener {
            // Handle settings click, e.g., open a settings activity
            // startActivity(Intent(this, SettingsActivity::class.java))
        }

        // Set up FloatingActionButton and other UI elements if needed
        // floatingActionButton.setOnClickListener { ... }
    }

    // Function to handle category selection
    private fun handleCategoryClick(category: String) {
        val intent = when (category) {
            "Hotels" -> Intent(this, HotelsActivity::class.java)
            "Adventures" -> Intent(this, AdventuresActivity::class.java)
            else -> null
        }
        intent?.let {
            startActivity(it)
        }
    }

    class CategoryAdapter(private val categories: List<String>, private val onClick: (String) -> Unit) :
        RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

        inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val categoryTextView: TextView = itemView.findViewById(R.id.hotelCategory1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.hotel_item_card, parent, false)
            return CategoryViewHolder(view)
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            val category = categories[position]

            // Set the category name in the TextView
            holder.categoryTextView.text = category

            // Set click listener for each category item
            holder.itemView.setOnClickListener {
                onClick(category)  // Invoke the callback with the clicked category
            }
        }

        override fun getItemCount(): Int = categories.size

        // Function to update categories (for filtering)
        fun updateCategories(newCategories: List<String>) {
            (categories as MutableList).clear()
            categories.addAll(newCategories)
            notifyDataSetChanged()
        }
    }
}
