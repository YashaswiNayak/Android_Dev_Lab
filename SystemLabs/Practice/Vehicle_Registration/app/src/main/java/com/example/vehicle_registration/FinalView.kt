package com.example.vehicle_registration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class FinalView:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.final_view)
        val vehicle_type=intent.getStringExtra("VehicleType")
        val vehicle_number=intent.getStringExtra("VehicleNumber")
        val vehicle_rc=intent.getStringExtra("VehicleRc")
        val dates=intent.getStringExtra("Dates")
        
        val vType=findViewById<TextView>(R.id.vehicle_type)
        val vNumber=findViewById<TextView>(R.id.vehicle_number)
        val vRc=findViewById<TextView>(R.id.vehicle_rc)
        val date=findViewById<TextView>(R.id.date)
        vType.text=vehicle_type
        vNumber.text=vehicle_number
        vRc.text=vehicle_rc
        date.text=dates
        val submitButton=findViewById<Button>(R.id.finalSubmit)
        val editButton=findViewById<Button>(R.id.edit)
        editButton.setOnClickListener {
            val editView = Intent(this, MainActivity::class.java).apply {
            }
            startActivity(editView)
        }
        submitButton.setOnClickListener {
            val layoutInflate=layoutInflater.inflate(R.layout.toast_view,null)
            val vtype=layoutInflate.findViewById<TextView>(R.id.vtype)
            val vnumber=layoutInflate.findViewById<TextView>(R.id.vnumber)
            val vrc=layoutInflate.findViewById<TextView>(R.id.vrc)
            val finalDate=layoutInflate.findViewById<TextView>(R.id.finalDate)
            vtype.text=vType.text
            vnumber.text=vNumber.text
            vrc.text=vRc.text
            finalDate.text=date.text
            val toast=Toast(this)
            toast.duration=Toast.LENGTH_SHORT
            toast.view=layoutInflate
            toast.show()
        }
    }
}
