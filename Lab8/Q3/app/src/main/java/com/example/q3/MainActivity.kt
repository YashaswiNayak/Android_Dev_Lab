package com.example.q3

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val reviewList= mutableListOf<String>()
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
        dbHelper=DBHelper(this,null)
        val saveButton=findViewById<Button>(R.id.save)
        val viewButton=findViewById<Button>(R.id.view)
        val movieName=findViewById<TextView>(R.id.movieName)
        val year=findViewById<TextView>(R.id.year)
        val review=findViewById<TextView>(R.id.review)
        val listView=findViewById<ListView>(R.id.listView)
        saveButton.setOnClickListener {
            val movieItem=Movie(movieName.text.toString(),year.text.toString().toInt(),review.text.toString().toDouble())
            dbHelper.addMovie(movieItem)
        }
        viewButton.setOnClickListener {
            getMovie()
            listView.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,reviewList)
        }
    }
    private fun getMovie(){
        val db=dbHelper.readableDatabase
        val cursor=db.rawQuery("SELECT * FROM ${DBHelper.TABLE_NAME}",null)
        var data:String
        while(cursor.moveToNext()){
            val name=cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.NAME))
            val year=cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.YEAR))
            val rating=cursor.getDouble(cursor.getColumnIndexOrThrow(DBHelper.RATING))
            val review=Movie(name,year,rating)
            data="Name: ${review.name}\nYear: ${review.year}\nRating: ${review.rating}\n"
            reviewList.add(data)
        }
        cursor.close()
        db.close()

    }
}