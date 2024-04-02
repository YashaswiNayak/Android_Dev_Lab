package com.example.q1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
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
        val names = arrayOf("Rucheems", "Aadarsh", "Shucheemshu uncle", "Prejwel", "Anudev")
        val listView: ListView = findViewById(R.id.phoneNames)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        listView.onItemLongClickListener = AdapterView.OnItemLongClickListener { _, _, position, _ ->
            val contactName = names[position]
            displayOptionsForContact(contactName)
            true
        }
    }

    private fun displayOptionsForContact(contactName: String) {
        // Here you can implement your logic to display options for the contact
        // For now, just display a toast message with the contact name
        Toast.makeText(this, "Long press on $contactName", Toast.LENGTH_SHORT).show()

        // Example: Open messaging app with empty message to the selected contact
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("sms:")
        intent.putExtra("sms_body", "")
        startActivity(intent)
    }
}