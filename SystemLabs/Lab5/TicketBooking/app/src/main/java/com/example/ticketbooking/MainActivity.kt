package com.example.ticketbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.ToggleButton
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val destinations = arrayOf("America", "Finland", "Argentina")
        val currentDate=Calendar.getInstance()
        val datePicker=findViewById<DatePicker>(R.id.startDate)
        datePicker.init(currentDate.get(Calendar.YEAR),currentDate.get(Calendar.MONTH),currentDate.get(Calendar.DAY_OF_MONTH),null)
        val toggleButton=findViewById<ToggleButton>(R.id.ticketType)
        val adapter = ArrayAdapter(
            this,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
            destinations
        )
        val source=findViewById<Spinner>(R.id.source)
        val destination = findViewById<Spinner>(R.id.destination)
        source.adapter=adapter
        destination.adapter = adapter
        val clear=findViewById<Button>(R.id.clear)
        val submit =findViewById<Button>(R.id.submit)
        clear.setOnClickListener {
            source.setSelection(0)
            destination.setSelection(0)
            toggleButton.isChecked=false
            datePicker.init(currentDate.get(Calendar.YEAR),currentDate.get(Calendar.MONTH),currentDate.get(Calendar.DAY_OF_MONTH),null)
        }
        submit.setOnClickListener {
            val sourceText=source.selectedItem.toString()
            val destinationText=destination.selectedItem.toString()
            val journeyType=if(toggleButton.isChecked) "to-fro" else "one-way"
            val selectedDate = formatDate(datePicker.year, datePicker.month, datePicker.dayOfMonth)
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("source", sourceText)
                putExtra("destination", destinationText)
                putExtra("date", selectedDate)
                putExtra("journeyType", journeyType)
            }
            startActivity(intent)
        }
    }
    private fun formatDate(year: Int, month: Int, dayOfMonth: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return sdf.format(calendar.time)
    }
}