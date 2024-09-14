package com.example.traveleasemad

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HotelsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var searchView: SearchView
    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    private lateinit var hotelsRecyclerView: RecyclerView
    private lateinit var categoryAdapter: HotelDashboardActivity.CategoryAdapter
    private val categories = listOf("Luxury", "Budget", "Hostel", "Boutique") // Example categories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this) // Set this activity as the callback for map readiness

        // Initialize views
        searchView = findViewById(R.id.searchView)
        hotelsRecyclerView = findViewById(R.id.hotelsRecyclerView)

        // Setup search view listener
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Show the map when a search is submitted
                mapView.visibility = View.VISIBLE

                // Implement search logic to filter the hotels based on 'query'
                filterHotels(query)

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Update the hotel list dynamically based on 'newText'
                filterHotels(newText)
                return true
            }
        })

        // Set up the RecyclerView with hotel data
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Initialize the RecyclerView with a GridLayoutManager to display cards in 2 columns
        hotelsRecyclerView.layoutManager = GridLayoutManager(this, 2)

        // Set up the CategoryAdapter to display hotel categories using the new card layout
        categoryAdapter = HotelDashboardActivity.CategoryAdapter(categories) { category ->
            // Handle click: Show hotels by category
            showHotelsByCategory(category)
        }

        hotelsRecyclerView.adapter = categoryAdapter
    }

    private fun filterHotels(query: String?) {
        // Implement search filtering logic to display relevant hotels
        if (!query.isNullOrEmpty()) {
            val filteredCategories = categories.filter { it.contains(query, ignoreCase = true) }
            categoryAdapter.updateCategories(filteredCategories)
        } else {
            // Reset to full list when no query
            categoryAdapter.updateCategories(categories)
        }
    }

    private fun showHotelsByCategory(category: String) {
        // Implement logic to display hotels based on the selected category
        mapView.visibility = View.VISIBLE
        val hotelDetails = getHotelDetailsForCategory(category)

        val intent = Intent(this, HotelDetailsActivity::class.java).apply {
            putExtra("HOTEL_DETAILS", hotelDetails)
        }
        startActivity(intent)

        // TODO: Display hotels on the map or list relevant hotels in the RecyclerView
    }
    private fun getHotelDetailsForCategory(category: String): String {
        // Replace with actual hotel details fetching logic
        return "Details for $category Hotel"
    }

    override fun onMapReady(gMap: GoogleMap) {
        googleMap = gMap

        // Add a marker in a location (example: Colombo, Sri Lanka)
        val colombo = LatLng(6.9271, 79.8612)
        googleMap.addMarker(MarkerOptions().position(colombo).title("Marker in Colombo"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(colombo, 10f))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }
}
