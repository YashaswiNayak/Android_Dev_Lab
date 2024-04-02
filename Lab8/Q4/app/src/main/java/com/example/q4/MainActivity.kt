package com.example.q4

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val studentList = mutableListOf<StudentDetails>()
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dbHelper = DBHelper(this,null)
        val submit = findViewById<Button>(R.id.submit)
        submit.setOnClickListener {
            val name = findViewById<EditText>(R.id.name).text.toString()
            val studentid = findViewById<EditText>(R.id.id).text.toString().toInt()
            val semester = findViewById<EditText>(R.id.semester).text.toString().toInt()
            val branch = findViewById<EditText>(R.id.branch).text.toString()
            val faculty = findViewById<EditText>(R.id.faculty).text.toString()
            val student = StudentDetails(name, studentid, semester, branch, faculty)
            dbHelper.insertData(student)
        }
        displayData() // Call the method to display data after inserting
        val show=findViewById<Button>(R.id.show)
        show.setOnClickListener {
            displayData()
            val listView=findViewById<ListView>(R.id.listView)
            listView.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,studentList)
        }

    }

    private fun displayData() {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM ${DBHelper.TABLE_NAME}", null)
        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.NAME))
            val studentid = cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.SEMESTER_ID))
            val semester = cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.SEM))
            val branch = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.BRANCH))
            val faculty = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.FACULTY))
            val student = StudentDetails(name, studentid, semester, branch, faculty)
            studentList.add(student)
        }
        cursor.close()
        db.close()
    }
}