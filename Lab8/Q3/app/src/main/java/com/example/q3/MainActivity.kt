package com.example.q3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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
        saveButton.setOnClickListener {
            val movieItem=Movie(movieName.text.toString(),year.text.toString().toInt(),review.text.toString().toDouble())
            dbHelper.addMovie(movieItem)
        }
        viewButton.setOnClickListener {
            getMovie()
        }
    }
    private fun getMovie(){
        val db=dbHelper.readableDatabase
        val cursor=db.rawQuery("SELECT * FROM ${DBHelper.TABLE_NAME}",null)
        val data=StringBuilder()
        while(cursor.moveToNext()){
            val id=cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.ID))
            val name=cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.NAME))
            val year=cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.YEAR))
            val rating=cursor.getDouble(cursor.getColumnIndexOrThrow(DBHelper.RATING))
            data.append("ID: $id,Name: $name,Year: $year,Rating: $rating\n")
        }
        findViewById<TextView>(R.id.display).text=data.toString()
        cursor.close()
        db.close()

    }
}