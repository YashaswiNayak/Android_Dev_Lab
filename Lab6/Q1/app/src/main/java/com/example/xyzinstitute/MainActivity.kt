package com.example.xyzinstitute

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize ListView here
        listView = findViewById(R.id.shit) // Make sure to replace 'your_list_view_id' with the correct ID
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_courses -> {
                listView.adapter = ArrayAdapter.createFromResource(this, R.array.course_list, android.R.layout.simple_list_item_1)
                true
            }
            R.id.nav_admission -> {
                listView.adapter = ArrayAdapter.createFromResource(this, R.array.admission_procedure, android.R.layout.simple_list_item_1)
                true
            }
            R.id.nav_faculty -> {
                listView.adapter = ArrayAdapter.createFromResource(this, R.array.faculty_list, android.R.layout.simple_list_item_1)
                true
            }
            R.id.nav_contact -> {
                listView.adapter = ArrayAdapter.createFromResource(this, R.array.contact_us_list, android.R.layout.simple_list_item_1)
                true
            }
            R.id.nav_about -> {
                listView.adapter = ArrayAdapter.createFromResource(this, R.array.about_us_list, android.R.layout.simple_list_item_1)
                true
            }
            R.id.nav_home -> {
                listView.adapter = ArrayAdapter.createFromResource(this, R.array.course_list, android.R.layout.simple_list_item_1)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}


