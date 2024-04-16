package com.example.database_practice

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

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
        val save=findViewById<Button>(R.id.save)
        val show=findViewById<Button>(R.id.show)
        val db=DBHelper(this,null)
        val listView=findViewById<ListView>(R.id.listView)
        val avg=findViewById<Button>(R.id.avg)
        save.setOnClickListener {
            val name=findViewById<EditText>(R.id.name).text.toString()
            val age=findViewById<EditText>(R.id.age).text.toString().toInt()
            val sub1=findViewById<EditText>(R.id.sub1).text.toString().toInt()
            val sub2=findViewById<EditText>(R.id.sub2).text.toString().toInt()
            val sub3=findViewById<EditText>(R.id.sub3).text.toString().toInt()
            val data=StudentData(name,age,sub1,sub2,sub3)
            db.addName(data)
        }
        show.setOnClickListener {
            val list=db.getAllItems()
            listView.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        }
        avg.setOnClickListener{
            val name=findViewById<EditText>(R.id.name).text.toString()
            val average=db.getAvg(name)
            findViewById<TextView>(R.id.averageDisplay).text="Average: $average"
        }


    }
}