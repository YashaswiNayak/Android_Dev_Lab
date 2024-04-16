package com.example.q2

import android.os.Bundle
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
        val button=findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val popupMenu = PopupMenu(this@MainActivity, button)

            // Inflating popup menu from popup_menu.xml file
            popupMenu.menuInflater.inflate(R.menu.items, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { menuItem ->
                // Toast message on menu item clicked
                Toast.makeText(this@MainActivity, "You Clicked " + menuItem.title, Toast.LENGTH_SHORT).show()
                true
            }
            // Showing the popup menu
            popupMenu.show()
        }
    }
}