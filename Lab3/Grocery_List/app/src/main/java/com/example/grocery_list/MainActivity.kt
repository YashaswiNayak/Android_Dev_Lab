package com.example.grocery_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val grocery_items = arrayOf("Apples", "Banana", "Chikoo", "Mango", "Pineapple")
        val listview = findViewById<ListView>(R.id.grocery_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, grocery_items)
        listview.adapter = adapter
        listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val value = adapter.getItem(position)
            Toast.makeText(applicationContext, value.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}