package com.example.vehicle_registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner=findViewById<Spinner>(R.id.vehicleType)
        val vehicleNo=findViewById<EditText>(R.id.vehicleNo)
        val vehicleRc=findViewById<EditText>(R.id.vehicleRC)
        spinner.adapter=ArrayAdapter.createFromResource(this, R.array.vehicles,android.R.layout.simple_spinner_dropdown_item)
        val datePicker=findViewById<DatePicker>(R.id.date)

        findViewById<Button>(R.id.Clear).setOnClickListener {
            spinner.setSelection(0)
            vehicleNo.setText("")
            vehicleRc.setText("")
            val calendar= Calendar.getInstance()
            datePicker.init(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),null)
        }
        findViewById<Button>(R.id.Submit).setOnClickListener {
            val year=datePicker.year
            val month=datePicker.month+1
            val day=datePicker.dayOfMonth
            val finalView= Intent(this, FinalView::class.java).apply {
                putExtra("VehicleType",spinner.selectedItem.toString())
                putExtra("VehicleNumber",vehicleNo.text.toString())
                putExtra("VehicleRc",vehicleRc.text.toString())
                putExtra("Dates","$day-$month-$year")
            }
            startActivity(finalView)
        }
    }
}