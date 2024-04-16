package com.example.q4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val textContent: TextView by lazy {
        findViewById(R.id.textContent)
    }
    private val demonetizationContent: String by lazy {
        getString(R.string.demonetization_content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filterButton = findViewById<Button>(R.id.filterButton)
        val sortButton = findViewById<Button>(R.id.sortButton)

        filterButton.setOnClickListener { showFilterMenu(filterButton) }
        sortButton.setOnClickListener { showSortMenu(sortButton) }

        textContent.text = demonetizationContent
    }

    private fun showFilterMenu(anchor: View) {
        val popupMenu = PopupMenu(this, anchor)
        popupMenu.menuInflater.inflate(R.menu.filter_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_keyword -> {
                    textContent.text = filterContent("Keyword")
                    showToast("Filtered by: Keyword")
                }
                R.id.menu_currency -> {
                    textContent.text = filterContent("Currency")
                    showToast("Filtered by: Currency")
                }
                R.id.menu_economy -> {
                    textContent.text = filterContent("Economy")
                    showToast("Filtered by: Economy")
                }
            }
            true
        }
        popupMenu.show()
    }

    private fun showSortMenu(anchor: View) {
        val popupMenu = PopupMenu(this, anchor)
        popupMenu.menuInflater.inflate(R.menu.sort_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_sort_az -> {
                    textContent.text = sortContent("Sort by A-Z")
                    showToast("Sorted by: A-Z")
                }
                R.id.menu_sort_za -> {
                    textContent.text = sortContent("Sort by Z-A")
                    showToast("Sorted by: Z-A")
                }
                R.id.menu_original -> {
                    textContent.text = demonetizationContent
                    showToast("Original")
                }
            }
            true
        }
        popupMenu.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun filterContent(filterOption: String): String {
        return when (filterOption) {
            "Keyword" -> demonetizationContent
            "Currency" -> {
                val filteredParts = demonetizationContent.split(" ").filter { word ->
                    word.contains("currency", ignoreCase = true)
                }
                filteredParts.joinToString(" ")
            }
            "Economy" -> {
                val filteredParts = demonetizationContent.split(" ").filter { word ->
                    word.contains("economy", ignoreCase = true)
                }
                filteredParts.joinToString(" ")
            }
            else -> demonetizationContent
        }
    }

    private fun sortContent(sortOption: String): String {
        return when (sortOption) {
            "Sort by A-Z" -> demonetizationContent.split(" ").sorted().joinToString(" ")
            "Sort by Z-A" -> demonetizationContent.split(" ").sortedDescending().joinToString(" ")
            "Original" -> demonetizationContent
            else -> demonetizationContent
        }
    }
}