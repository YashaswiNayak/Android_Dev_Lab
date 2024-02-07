package com.example.vehicleregistration

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class FinalView: AppCompatActivity() {
    override fun onCreate(savedInstanceBundle: Bundle?){
        super.onCreate(savedInstanceBundle)
        setContentView(R.layout.final_view)
        val vehicleType=intent.getStringExtra("Type").toString()
        val vehicleNumber=intent.getStringExtra("vehicleNumber").toString()
        val vehicleRC=intent.getStringExtra("vehicleRC").toString()
        val displayVehicle=findViewById<TextView>(R.id.VehicleType)
        val displayVehicleNo=findViewById<TextView>(R.id.VehicleNumber)
        val displayVehicleRC=findViewById<TextView>(R.id.VehicleRC)
        displayVehicle.text=vehicleType
        displayVehicleNo.text=vehicleNumber
        displayVehicleRC.text=vehicleRC
        val edit=findViewById<Button>(R.id.edit)
        edit.setOnClickListener {
            val prevView=Intent(this,MainActivity::class.java)
            startActivity(prevView)
        }
        val submit=findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val toast=this.layoutInflater.inflate(R.layout.custom_toast,null)
            val type=toast.findViewById<TextView>(R.id.type)
            val number=toast.findViewById<TextView>(R.id.number)
            val rc=toast.findViewById<TextView>(R.id.rcnumber)
            type.text=vehicleType
            number.text=vehicleNumber
            rc.text=vehicleRC
            val view=Toast(this)
            view.duration=Toast.LENGTH_SHORT
            view.view=toast
            view.show()
        }

    }
}