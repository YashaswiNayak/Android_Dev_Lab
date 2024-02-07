package com.example.ring_silent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toggle=findViewById<ToggleButton>(R.id.toggleButton)
        val action=findViewById<Button>(R.id.actionButton)
        val img=findViewById<ImageView>(R.id.image)
        action.setOnClickListener {
            val currentstate=if(toggle.isChecked )"Ringing" else "Silent"
            Toast.makeText(this,"Current state: $currentstate", Toast.LENGTH_SHORT).show()
        }
        toggle.setOnCheckedChangeListener { _, isChecked ->
            val image=if(toggle.isChecked) R.drawable.ic_launcher_background else R.drawable.ic_launcher_foreground
            img.setBackgroundResource(image)
            val curstate=if(toggle.isChecked )"Ringing" else "Silent"
            Toast.makeText(this,"Current state: $curstate", Toast.LENGTH_SHORT).show()
        }
    }
}