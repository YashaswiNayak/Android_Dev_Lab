package com.example.timeanddatepicker

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class FinalView: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.final_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.final_view)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val finalSource=intent.getStringExtra("source")
        val finalDestination=intent.getStringExtra("destination")
        val finalTime=intent.getStringExtra("time")
        val fs=findViewById<TextView>(R.id.finalSource)
        fs.text=finalSource.toString()
        val fd=findViewById<TextView>(R.id.finalDestination)
        fd.text=finalDestination.toString()
        val ft=findViewById<TextView>(R.id.finalTime)
        ft.text=finalTime.toString()


    }
}