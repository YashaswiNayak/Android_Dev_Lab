package com.example.q4

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val demonetizationContent: String by lazy {
        getString(R.string.demonetization_content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filterSpinner = findViewById<Spinner>(R.id.filterSpinner)
        val sortSpinner = findViewById<Spinner>(R.id.sortSpinner)
        val textContent = findViewById<TextView>(R.id.textContent)
        // Set up filter spinner
        val filterOptions = resources.getStringArray(R.array.filter_options)
        val filterAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, filterOptions)
        filterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        filterSpinner.adapter = filterAdapter

        filterSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                // Handle filter selection
                val selectedFilter = parent?.getItemAtPosition(position).toString()
                val filteredContent = filterContent(selectedFilter)
                textContent.text = filteredContent
                Toast.makeText(this@MainActivity, "Filtered by: $selectedFilter", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Set up sort spinner
        val sortAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.sort_options,
            android.R.layout.simple_spinner_item
        )
        sortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sortSpinner.adapter = sortAdapter

        sortSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: android.view.View?,
                position: Int,
                id: Long
            ) {
                // Handle sort selection
                val selectedSort = parent?.getItemAtPosition(position).toString()
                val sortedContent = sortContent(selectedSort)
                textContent.text = sortedContent
                Toast.makeText(this@MainActivity, "Sorted by: $selectedSort", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun filterContent(filterOption: String): String {
        return when (filterOption) {
            "Keyword" -> demonetizationContent // No need to filter if "Keyword" option is selected
            "Currency" -> {
                // Filter content based on the "Currency" keyword
                val filteredParts = demonetizationContent.split(" ").filter { word ->
                    word.contains("currency", ignoreCase = true)
                }
                filteredParts.joinToString(" ")
            }
            "Economy" -> {
                // Filter content based on the "Economy" keyword
                val filteredParts = demonetizationContent.split(" ").filter { word ->
                    word.contains("economy", ignoreCase = true)
                }
                filteredParts.joinToString(" ")
            }
            else -> demonetizationContent // Default to displaying the original content
        }
    }

    private fun sortContent(sortOption: String): String {
        return when (sortOption) {
            "Sort by A-Z" -> demonetizationContent.split(" ").sorted().joinToString(" ")
            "Sort by Z-A" -> demonetizationContent.split(" ").sortedDescending().joinToString(" ")
            "Original"->demonetizationContent
            else -> demonetizationContent
        }
    }
}