package com.example.timepicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.ToggleButton
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var sourceSpinner: Spinner
    private lateinit var destinationSpinner: Spinner
    private lateinit var datePicker: DatePicker
    private lateinit var timePicker: TimePicker
    private lateinit var toggleButton: ToggleButton
    private lateinit var submitBtn: Button
    private lateinit var clearBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sourceSpinner = findViewById(R.id.sourceSpinner)
        destinationSpinner = findViewById(R.id.destinationSpinner)
        datePicker = findViewById(R.id.datePicker)
        timePicker = findViewById(R.id.timePicker)
        toggleButton = findViewById(R.id.toggleButton)
        submitBtn = findViewById(R.id.submitBtn)
        clearBtn = findViewById(R.id.clearBtn)

        submitBtn.setOnClickListener {
            handleSubmit()
        }

        clearBtn.setOnClickListener {
            handleClear()
        }
    }

    private fun handleSubmit() {
        val source = sourceSpinner.selectedItem.toString()
        val destination = destinationSpinner.selectedItem.toString()

        val calendar = Calendar.getInstance()
        calendar.set(datePicker.year, datePicker.month, datePicker.dayOfMonth, timePicker.hour, timePicker.minute)
        val selectedTime = calendar.time

        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val formattedTime = sdf.format(selectedTime)

        val intent = Intent(this, DisplayDetailsActivity::class.java).apply {
            putExtra("source", source)
            putExtra("destination", destination)
            putExtra("time", formattedTime)
            putExtra("isTatkal", toggleButton.isChecked)
        }
        startActivity(intent)
    }

    private fun handleClear() {
        val calendar = Calendar.getInstance()
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null)
        timePicker.currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        timePicker.currentMinute = calendar.get(Calendar.MINUTE)

        sourceSpinner.setSelection(0)
        destinationSpinner.setSelection(0)
        toggleButton.isChecked = false
    }
}