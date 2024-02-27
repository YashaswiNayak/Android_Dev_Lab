package com.example.ticketbooking

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val sourceTextView=findViewById<TextView>(R.id.sourceTextView)
        val destinationTextView=findViewById<TextView>(R.id.destinationTextView)
        val dateTextView=findViewById<TextView>(R.id.dateTextView)
        val journeyTypeTextView=findViewById<TextView>(R.id.journeyTypeTextView)
        // Retrieve data from intent
        val source = intent.getStringExtra("source")
        val destination = intent.getStringExtra("destination")
        val date = intent.getStringExtra("date")
        val journeyType = intent.getStringExtra("journeyType")

        // Display the details in TextViews
        sourceTextView.text = "Source: $source"
        destinationTextView.text = "Destination: $destination"
        dateTextView.text = "Date: $date"
        journeyTypeTextView.text = "Journey Type: $journeyType"
    }
}