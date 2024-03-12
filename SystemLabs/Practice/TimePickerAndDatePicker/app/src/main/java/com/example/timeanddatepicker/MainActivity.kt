    package com.example.timeanddatepicker

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

    class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val timePicker=findViewById<TimePicker>(R.id.time)
        timePicker.setIs24HourView(true)
        val submit=findViewById<Button>(R.id.submit)
        val clear=findViewById<Button>(R.id.clear)
        val source=findViewById<Spinner>(R.id.source)
        val destination=findViewById<Spinner>(R.id.destination)
        source.adapter=ArrayAdapter.createFromResource(this,R.array.places,android.R.layout.simple_spinner_item)
        destination.adapter=ArrayAdapter.createFromResource(this,R.array.places,android.R.layout.simple_spinner_item)
        clear.setOnClickListener{
            source.setSelection(0)
            destination.setSelection(0)
            val calendar=Calendar.getInstance()
            timePicker.hour = calendar.get(Calendar.HOUR_OF_DAY)
            timePicker.minute=calendar.get(Calendar.MINUTE)
        }
        submit.setOnClickListener {
            val hour=timePicker.currentHour.toString()
            val min=timePicker.currentMinute.toString()
            val finalView=Intent(this,FinalView::class.java).apply{
                putExtra("source",source.getSelectedItem().toString())
                putExtra("destination",destination.getSelectedItem().toString())
                putExtra("time","$hour:$min")
        }
            startActivity(finalView)
        }

    }
}