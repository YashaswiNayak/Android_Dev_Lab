package com.example.vehicleregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner:Spinner=findViewById<Spinner>(R.id.VehicleType)
        val adapter= ArrayAdapter.createFromResource(this,R.array.vehicles,
            com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter=adapter
        val submit=findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val selectedVehicle=spinner.selectedItem.toString()
            val vehicleNo=findViewById<EditText>(R.id.Number).text.toString()
            val vehicleRC=findViewById<EditText>(R.id.RC).text.toString()
            val finalView=Intent(this,FinalView::class.java).apply {
                putExtra("Type",selectedVehicle)
                putExtra("vehicleNumber",vehicleNo)
                putExtra("vehicleRC",vehicleRC)
            }
            startActivity(finalView)
        }

    }
}