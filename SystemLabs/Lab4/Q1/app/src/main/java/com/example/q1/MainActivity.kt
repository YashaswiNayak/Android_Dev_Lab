package com.example.q1

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button =findViewById<Button>(R.id.button)
        val toggle_button= findViewById<ToggleButton>(R.id.toggle_button)
        button.setOnClickListener {
            val inflater=this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout=inflater.inflate(R.layout.custom_inflater,null)

            val image=layout.findViewById<ImageView>(R.id.image)
            image.setBackgroundResource(R.drawable.chocolate_chocolate_cake_1)
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = layout
            toast.show()


        }
        toggle_button.setOnCheckedChangeListener { buttonView, isChecked ->
            val inflater=this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout=inflater.inflate(R.layout.custom_inflater,null)
            val image=layout.findViewById<ImageView>(R.id.image)
            image.setBackgroundResource(if (isChecked) R.drawable.blue else R.drawable.green)
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = layout
            toast.show()

        }
    }
}