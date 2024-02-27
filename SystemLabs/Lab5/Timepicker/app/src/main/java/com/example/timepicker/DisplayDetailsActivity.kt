package com.example.timepicker
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class DisplayDetailsActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_details)

        val detailsTextView: TextView = findViewById(R.id.detailsTextView)

        val source = intent.getStringExtra("source")
        val destination = intent.getStringExtra("destination")
        val time = intent.getStringExtra("time")
        val isTatkal = intent.getBooleanExtra("isTatkal", false)

        val details = "Source: $source\nDestination: $destination\nTime: $time\nIs Tatkal: $isTatkal"
        detailsTextView.text = details
    }
}